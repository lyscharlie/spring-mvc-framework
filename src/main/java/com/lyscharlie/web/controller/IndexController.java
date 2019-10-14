package com.lyscharlie.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyscharlie.common.utils.CookieUtils;
import com.lyscharlie.web.core.cookie.SessionKeeper;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping({"/", "/index.htm", "/home.htm"})
	public String indexPage(HttpServletRequest request, ModelMap model) {

		String a = request.getParameter("a");
		if (StringUtils.isNotBlank(a)) {
			model.put("name", a);
		} else {
			String username = CookieUtils.getDecoderCookieValueByName(request, SessionKeeper.COOKIE.USER_NAME);
			if (StringUtils.isNotBlank(username)) {
				model.put("name", username);
			} else {
				model.put("name", "nobody");
			}
		}

		return "screen/index";
	}

	@GetMapping("redirect.htm")
	public String redirect(HttpServletRequest request) {
		String baseHost = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
		return "redirect:" + baseHost + "test/test.htm";
	}

}
