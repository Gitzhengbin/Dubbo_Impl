package Dao;

import java.util.List;

import Entity.User;

public interface UserDao {
	
	public void add(User user);
	
	public List<User> getUser();
	
	public void delete(int id);
	
	
}
