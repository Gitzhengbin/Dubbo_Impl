package Test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Entity.User;
import Service.HelloService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:dubbo_serviceimpl.xml"})
public class test {
	@Resource HelloService helloService;
	
	@Test
	public void testList() {
		List<User> list = helloService.getUser();
		System.out.println(list);
	}
	
	@Test
	public void testAdd() {
		User user = new User();
		user.setUsername("Zhengbin4");
		user.setPassword("9509064");
		helloService.addUser(user);
	}
	
	@Test
	public void testDelete() {
		int id = 9;
		helloService.deleteUser(id);
	}
	
}