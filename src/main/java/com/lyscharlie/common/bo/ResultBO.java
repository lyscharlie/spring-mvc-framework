package com.lyscharlie.common.bo;

import java.io.Serializable;

public class ResultBO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3207484677360279293L;

	protected boolean success;
	protected T module;
	protected String code = "";
	protected String msg = "";

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getModule() {
		return module;
	}

	public void setModule(T module) {
		this.module = module;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
