package domain;

import javax.persistence.*;

@Entity
@Table(name="friend")
public class Friend {
	private int fid;
	private User user;
	private User friend;
	private String friendnickname;
	
	@Id
	@GeneratedValue
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	
	@Column(name="friendnickname")
	public String getFriendnickname() {
		return friendnickname;
	}
	public void setFriendnickname(String friendnickname) {
		this.friendnickname = friendnickname;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_userid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="friend_userid")
	public User getFriend() {
		return friend;
	}
	public void setFriend(User friend) {
		this.friend = friend;
	}
}
