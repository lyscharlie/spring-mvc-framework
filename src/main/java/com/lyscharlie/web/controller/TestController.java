package com.lyscharlie.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lyscharlie.biz.core.test.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("/test.htm")
	public ModelAndView test(@RequestParam(value = "v", defaultValue = "") String v) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("screen/test");
		modelAndView.addObject("value", v);
		return modelAndView;
	}

	@RequestMapping("/test1.htm")
	public String test1(HttpServletRequest request) {
		String v = request.getParameter("v");
		request.setAttribute("value", v);
		return "screen/test";
	}

	@ResponseBody
	@RequestMapping("/test2.htm")
	public Map<String, Object> test2() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("maxInteger", Integer.MAX_VALUE);
		map.put("minInteger", Integer.MIN_VALUE);
		map.put("maxDouble", Double.MAX_VALUE);
		map.put("minDouble", Double.MIN_VALUE);
		return map;
	}

	@ResponseBody
	@RequestMapping("/test3.htm")
	public List<Integer> test3() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		return list;
	}

	@RequestMapping("/test4.htm")
	public ModelAndView test4(Integer v) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("value", v);
		mv.setViewName("screen/test");
		return mv;
	}

	@RequestMapping("/test5/{a}-{b}.htm")
	public ModelAndView test5(@PathVariable String a, @PathVariable String b) {
		ModelAndView mv = new ModelAndView();
		String value = a + "_" + b;
		mv.addObject("value", value);
		mv.setViewName("screen/test");
		return mv;
	}

	@ResponseBody
	@RequestMapping("/test6.htm")
	public Object test6(@RequestParam(value = "callback", defaultValue = "") String callback) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("maxInteger", Integer.MAX_VALUE);
		map.put("minInteger", Integer.MIN_VALUE);
		map.put("maxDouble", Double.MAX_VALUE);
		map.put("minDouble", Double.MIN_VALUE);

		if (StringUtils.isBlank(callback)) {
			return map;
		} else {
			// 如果callback字符串不为空，需要支持jsonp调用 spring4.1 以上可用
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(map);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}
	}

	@RequestMapping("/test7.htm")
	public ModelAndView test7() {
		String v = this.testService.readConfig();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("screen/test");
		modelAndView.addObject("value", v);
		return modelAndView;
	}

}
