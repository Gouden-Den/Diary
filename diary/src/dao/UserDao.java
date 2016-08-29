package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import domain.Friend;
import domain.User;

public class UserDao {
private SessionFactory sessionFactory;
	
	//注册用
	public int register(User user){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int num = 0;
		try{
			tx = session.getTransaction();
			session.save(user);
			num = 1;
			tx.commit();
		}catch(RuntimeException e){
			//tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
		return num;
	}
	
	//注册的时候检验是否存在该用户名
	public boolean ifUsernameExist(String username){
		Session session = sessionFactory.openSession();
		String hql = "from User user where user.username = '" + username + "'";
		boolean flag = false;
		try{
			List list = session.createQuery(hql).list();
			if(list.size() > 0){
				flag = true;
			}
			session.close();
			return flag;
		}catch(RuntimeException e){
			throw e;
		}
	}
	
	//登录用
	public User login(String username, String password){
		Session session = sessionFactory.openSession();
		User user =  new User();
		String hql = "from User where username='"+username+"' and password='"+password+"'";
		List list = session.createQuery(hql).list();
		if(list.size() > 0){
			user = (User) list.get(0);
		}
		session.close();
		return user;
	}
	
	//修改个人信息
	public boolean update(User user){
		Session session = sessionFactory.openSession();
		boolean flag = false;
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			session.update(user);
			flag = true;
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			throw new RuntimeException();
		}finally{
			session.close();
		}
		
		return flag;
	}
	
	//根据id查询用户
	public User getUser(int userid){
		Session session = sessionFactory.openSession();
		User user = null;
		user = (User) session.get(User.class, userid);
		session.close();
		return user;
	}
	
	//得到所有好友
	public List<User> getAllFriends(int userid){
		Session session = sessionFactory.openSession();
		String hql = "from User u, Friend f where f.userid="+userid+" and u.userid=f.friendid";
		List<User> list = session.createQuery(hql).list();
		session.close();
		return list;
	}
	
	//添加好友
	public boolean addFriend(int userid, int friendid){
		Session session = sessionFactory.openSession();
		boolean flag = false;
		Transaction tx = null;
		Friend friend = new Friend();
		friend.setUser(this.getUser(userid));
		friend.setFriend(this.getUser(friendid));
		try{
			tx = session.beginTransaction();
			session.save(friend);
			tx.commit();
			flag = true;
		}catch(Exception e){
			throw new RuntimeException();
		}
		session.close();
		return flag;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
