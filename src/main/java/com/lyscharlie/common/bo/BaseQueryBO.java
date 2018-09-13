package com.lyscharlie.common.bo;

import java.io.Serializable;

/**
 * 公用分页查询条件BO
 */
public class BaseQueryBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1272161553262562523L;

	private int pageSize = 20;
	private int pageNo = 1;
	private int record;
	private boolean isPage;

	public int getPageSize() {
		if (pageSize < 0) return 20;// 默认一页20个
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		if (pageNo < 1) {
			return 1;
		}
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageIndex() {
		return (getPageNo() - 1) * getPageSize();
	}

	public int getRecord() {
		if (record < 0) {
			return 0;
		}
		return record;
	}

	/**
	 * 设置总记录数
	 */
	public void setRecord(int record) {
		this.record = record;
	}

	/**
	 * 获取总页数
	 */
	public int getTotalPages() {
		if (record % getPageSize() == 0) {
			return record / getPageSize();
		} else {
			return record / getPageSize() + 1;
		}
	}

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}
}
