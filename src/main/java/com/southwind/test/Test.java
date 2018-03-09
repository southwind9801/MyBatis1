package com.southwind.test;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.southwind.dao.UserDAO;
import com.southwind.entity.User;

public class Test {
	public static void main(String[] args) {
		//加载MyBatis配置文件
		InputStream is = Test.class.getClassLoader().getResourceAsStream("config.xml");
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		//获取SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//获取实现接口的代理对象
		UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
		
		//新增用户
		User user = new User();
		user.setUsername("张三");
		user.setPassword("123");
		user.setAge(22);
		System.out.println(userDAO.addUser(user));
		sqlSession.commit();
		
//		//删除用户
//		System.out.println(userDAO.deleteUser(2));
//		sqlSession.commit();
//		
//		//查询用户
//		User user = userDAO.selectUserById(3);
//		System.out.println(user);
//		
//		//修改用户
//		User user = userDAO.selectUserById(3);
//		user.setUsername("李四");
//		System.out.println(userDAO.updateUser(user));
//		sqlSession.commit();
	}
}
