package DaoImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import Cache.UserCache;
import Dao.UserDao;
import Entity.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao,Serializable {
	private static final long serialVersionUID = 1791017557025477016L;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		System.out.println("载入SqlSessionFactory");
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void add(User user) {
		super.getSqlSession().insert("com.dao.user.mapper.addUser", user);
		int id = super.getSqlSession().selectOne("com.dao.user.mapper.getId");
		System.out.println("添加User:id="+id);
		user.setId(id);
		UserCache.addUser(user);
	}
	
	public List<User> getUser() {
		if(UserCache.isEmpty()) {
			System.out.println("缓存为空，从数据库中读取");
			List<User> list = new ArrayList<User>();
			list = super.getSqlSession().selectList("com.dao.user.mapper.getAllUser");
			UserCache.addAll(list);
		}
		return UserCache.getUser();
	}

	public void delete(int id) {
		UserCache.deleteUser(id);
		System.out.println("删除缓存");
		super.getSqlSession().delete("com.dao.user.mapper.deleteUser",id);
	}
	

}
