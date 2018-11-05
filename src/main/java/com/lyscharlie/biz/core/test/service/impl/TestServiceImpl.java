package com.lyscharlie.biz.core.test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lyscharlie.biz.core.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String readConfig() {
		try {
			return "abcd";
		} catch (Exception e) {
			logger.error("", e);
			return null;
		}
	}

}
