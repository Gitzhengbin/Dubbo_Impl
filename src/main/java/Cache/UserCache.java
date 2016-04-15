package Cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Entity.User;

public class UserCache {
	static Map<Integer, User> map = new LinkedHashMap<Integer, User>();
	
	public static void addUser(User user) {
		map.put(user.getId(), user);
	}
	
	public static void deleteUser(int id) {
		map.remove(id);
	}
	
	public static List<User> getUser() {
		List<User> list = new ArrayList<User>();
		for(Integer i : map.keySet()) {
			list.add(map.get(i));
		}
		return list;
	}
	
	public static boolean isEmpty() {
		return map.isEmpty();
	}
	
	public static void addAll(List<User> list) {
		for(User u : list){
			map.put(u.getId(), u);
		}
	}
	
}