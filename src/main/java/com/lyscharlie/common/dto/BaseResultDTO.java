package com.lyscharlie.common.dto;

import java.io.Serializable;

/**
 * 接口返回结果封装true/false
 */
public class BaseResultDTO implements Serializable {

	private static final long serialVersionUID = 8634580794272004072L;

	protected boolean success = false;
	protected String resultCode;
	protected String errorDetail;

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isFailed() {
		return !success;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

}
