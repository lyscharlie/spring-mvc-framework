package com.lyscharlie.biz.core.user.service;

import com.lyscharlie.biz.core.user.domain.UserDO;
import com.lyscharlie.common.dto.BaseResultDTO;
import com.lyscharlie.common.dto.ResultDTO;

public interface UserService {

	/**
	 * 注册新用户
	 * 
	 * @param user
	 * @return
	 */
	public BaseResultDTO registerUser(UserDO user);

	/**
	 * 查询用户
	 * 
	 * @param userName
	 * @return
	 */
	public ResultDTO<UserDO> queryUserByName(String userName);

}
