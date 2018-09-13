package com.lyscharlie.biz.core.test.timetask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestTimetask {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		logger.info("start time task");
		try {
			Thread.sleep(40 * 1000L);
		} catch (InterruptedException e) {
			logger.error("sleep error", e);
		}
		logger.info(sdf.format(date));
		logger.info("end time task");
	}
}
