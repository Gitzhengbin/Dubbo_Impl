package Service;

import java.util.List;

import Entity.User;

public interface HelloService {
	
	public String sayHello();
	
	public void addUser(User user);
	
	public List<User> getUser();
	
	public void deleteUser(int id);
	
}
