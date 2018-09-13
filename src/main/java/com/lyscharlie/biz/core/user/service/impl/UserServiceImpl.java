package com.lyscharlie.biz.core.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lyscharlie.biz.core.user.dao.UserDao;
import com.lyscharlie.biz.core.user.domain.UserDO;
import com.lyscharlie.biz.core.user.service.UserService;
import com.lyscharlie.common.dto.BaseResultDTO;
import com.lyscharlie.common.dto.ResultDTO;

public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;

	@Override
	public BaseResultDTO registerUser(UserDO user) {
		BaseResultDTO result = new BaseResultDTO();

		try {
			if (this.userDao.selectCountUserByName(user.getUserName()) > 0) {
				result.setSuccess(false);
				result.setErrorDetail("用户名已被注册");
				return result;
			}

			if (this.userDao.selectCountUserByEmail(user.getEmail()) > 0) {
				result.setSuccess(false);
				result.setErrorDetail("邮箱已被注册");
				return result;
			}

			int num = this.userDao.insertUser(user);
			if (num > 0) {
				result.setSuccess(true);
			} else {
				result.setSuccess(false);
				result.setErrorDetail("注册失败");
			}

		} catch (Exception e) {
			logger.error("call UserServiceImpl.registerUser error", e);
			result.setSuccess(false);
			result.setErrorDetail("系统异常");
		}

		return result;
	}

	@Override
	public ResultDTO<UserDO> queryUserByName(String userName) {
		ResultDTO<UserDO> result = new ResultDTO<UserDO>();

		try {
			UserDO user = this.userDao.selectUserByName(userName);

			result.setModule(user);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("call UserServiceImpl.queryUserByName error", e);
			result.setSuccess(false);
			result.setErrorDetail("系统异常");
		}
		
		return result;
	}

}
