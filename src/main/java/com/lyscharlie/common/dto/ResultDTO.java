package com.lyscharlie.common.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 单个结果封装
 */
public class ResultDTO<T> extends BaseResultDTO {

	private static final long serialVersionUID = -7724400142973976404L;

	protected T module;

	// 保存详细的校验错误信息
	protected Map<String, String> checkErrorInfo = new HashMap<String, String>();

	public ResultDTO() {
	}

	public ResultDTO(T module) {
		this.module = module;
	}

	public T getModule() {
		return module;
	}

	public void setModule(T module) {
		this.module = module;
	}

	public void addCheckErrorInfo(String code, String message) {
		checkErrorInfo.put(code, message);
	}

	public void addCheckErrorInfos(Map<String, String> infos) {
		checkErrorInfo.putAll(infos);
	}

	public Map<String, String> getCheckErrorInfo() {
		return checkErrorInfo;
	}

	public static <T> ResultDTO<T> getResult() {
		return new ResultDTO<T>();
	}

}
