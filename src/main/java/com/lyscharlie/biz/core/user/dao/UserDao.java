package com.lyscharlie.biz.core.user.dao;

import org.apache.ibatis.annotations.Param;

import com.lyscharlie.biz.core.user.domain.UserDO;

public interface UserDao {

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	public int insertUser(UserDO user);

	/**
	 * 根据用户ID查询用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public UserDO selectUserById(@Param("userId") Long userId);

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param userName
	 * @return
	 */
	public UserDO selectUserByName(@Param("userName") String userName);

	/**
	 * 查询用户数量
	 * 
	 * @param userName
	 * @return
	 */
	public int selectCountUserByName(@Param("userName") String userName);

	/**
	 * 查询邮箱数量
	 * 
	 * @param email
	 * @return
	 */
	public int selectCountUserByEmail(@Param("email") String email);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(UserDO user);

	/**
	 * 更新用户最后登录时间
	 * 
	 * @param userId
	 * @return
	 */
	public int updateLastLoginTime(@Param("userId") Long userId);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public int updatePassword(@Param("userId") Long userId, @Param("password") String password);
}
