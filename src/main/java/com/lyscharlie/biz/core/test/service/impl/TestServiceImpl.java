package com.lyscharlie.biz.core.test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lyscharlie.biz.core.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${data.value}")
	private String dataValue;

	@Override
	public String readConfig() {
		try {
			return dataValue;
		} catch (Exception e) {
			logger.error("TestServiceImpl.readConfig", e);
			return null;
		}
	}

}
