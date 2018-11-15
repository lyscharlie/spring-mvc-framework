package com.lyscharlie.biz.core.test.timetask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class TestTimetask {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 传统XML配置调度任务
	 */
	public void test1() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		logger.info("start time task - test1");
		try {
			logger.info(sdf.format(date));
		} catch (Exception e) {
			logger.error("TestTimetask.test1", e);
		}

		logger.info("end time task - test1");
	}

	/**
	 * 注解调度任务
	 */
	@Scheduled(cron = "${timeTask.test2.cronExpression}")
	public void test2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		logger.info("start time task - test2");
		try {
			logger.info(sdf.format(date));
		} catch (Exception e) {
			logger.error("TestTimetask.test2", e);
		}

		logger.info("end time task - test2");
	}
}
