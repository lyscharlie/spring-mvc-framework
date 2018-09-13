package com.lyscharlie.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lyscharlie.biz.core.user.domain.UserDO;
import com.lyscharlie.biz.core.user.service.UserService;
import com.lyscharlie.common.dto.ResultDTO;
import com.lyscharlie.common.utils.CookieUtils;
import com.lyscharlie.common.utils.EncryptUtils;
import com.lyscharlie.web.core.cookie.SessionKeeper;

@Controller
@RequestMapping("/sys")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login.htm")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("screen/sys/login");
		return mv;
	}

	/**
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("/do_login.htm")
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		if (StringUtils.isBlank(userName)) {
			mv.addObject("msg", "请输入用户名");
			mv.setViewName("screen/sys/login");
			return mv;
		}

		if (StringUtils.isBlank(password)) {
			mv.addObject("msg", "请输入密码");
			mv.setViewName("screen/sys/login");
			return mv;
		}

		ResultDTO<UserDO> r = this.userService.queryUserByName(userName);
		if (r.isSuccess()) {
			if (null == r.getModule()) {
				mv.addObject("userName", userName);
				mv.addObject("msg", "用户名或密码错误");
				mv.setViewName("screen/sys/login");
				return mv;
			} else {
				UserDO user = r.getModule();
				if (!StringUtils.equals(user.getPassword(), EncryptUtils.encodeMD5(password))) {
					mv.addObject("userName", userName);
					mv.addObject("msg", "用户名或密码错误");
					mv.setViewName("screen/sys/login");
					return mv;
				}

				CookieUtils.addCookie(response, SessionKeeper.COOKIE.USER_ID, user.getUserId().toString(), 3600, null);
				CookieUtils.addEncoderCookie(response, SessionKeeper.COOKIE.USER_NAME, user.getUserId().toString(), 3600, null);
				session.setAttribute(SessionKeeper.SESSION.USER_INFO, user);
			}

		} else {
			mv.addObject("userName", userName);
			mv.addObject("msg", "系统正忙，请稍后再试");
			mv.setViewName("screen/sys/login");
			return mv;
		}

		mv.setViewName("redirect:/index.htm");
		return mv;
	}

}
