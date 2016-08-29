package service;

import java.util.List;

import dao.UserDao;
import domain.User;

public class UserService {
	private UserDao userDao;

	public int register(User user){
		return userDao.register(user);
	}
	public boolean ifUsernameExist(String username){
		return userDao.ifUsernameExist(username);
	}
	public User login(String username, String password){
		return userDao.login(username, password);
	}
	public boolean update(User user){
		return userDao.update(user);
	}
	public User getUser(int userid){
		return userDao.getUser(userid);
	}
	public List<User> getAllFriends(int userid){
		return userDao.getAllFriends(userid);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
