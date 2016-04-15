package ServiceImpl;

import java.util.List;

import Dao.UserDao;
import Entity.User;
import Service.HelloService;

public class HelloServiceImpl implements HelloService{

	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		System.out.println("载入UserDao");
		this.userDao = userDao;
	}
	
	public String sayHello() {
		return "Hello World";
	}
	
	public void addUser(User user) {
		userDao.add(user);
	}
	
	public List<User> getUser() {
		return userDao.getUser();
	}

	public void deleteUser(int id) {
		userDao.delete(id);
	}

}