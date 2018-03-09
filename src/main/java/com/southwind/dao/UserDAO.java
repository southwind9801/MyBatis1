package com.southwind.dao;

import com.southwind.entity.User;

public interface UserDAO {
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser(int id);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	public User selectUserById(int id);
	
}
