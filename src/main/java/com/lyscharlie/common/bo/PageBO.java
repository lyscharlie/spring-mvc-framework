package com.lyscharlie.common.bo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 页面封装类
 */
public class PageBO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5064633824817803051L;

	protected int pageNo = 1;
	protected int pageSize = 10;

	/**
	 * 返回结果
	 */
	protected List<T> result = Collections.emptyList();
	protected int totalPages = 0;
	protected int records = 0;
	protected boolean success = true;
	protected String msg = "成功";

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 构造器
	 */
	public PageBO(){
	}

	public PageBO(int pageSize){
		setPageSize(pageSize);
	}

	public PageBO(int totalPages, List<T> result){
		this.totalPages = totalPages;
		this.result = result;
	}

	public PageBO(int totalPages, int records, List<T> result){
		this.totalPages = totalPages;
		this.result = result;
		this.records = records;
	}

	public PageBO(int pageNo, int totalPages, int pageSize, List<T> result){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.result = result;
	}

	public PageBO(int pageNo, int pageSize, int totalPages, int records, List<T> result){
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
		this.records = records;
		this.result = result;
	}

	/**
	 * 获取总的记录数，默认为0
	 * 
	 * @return
	 */
	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	/**
	 * 获得当前页的页号, 序号从 1 开始, 默认为 1
	 * 
	 * @return
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * 设置当前页的页号, 序号从 1 开始, 低于 1 时自动调整为 1
	 * 
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo < 1 ? 1 : pageNo;
	}

	/**
	 * 设置每页的记录数量, 低于 1 时自动调整为 1
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize < 1 ? 1 : pageSize;
	}

	/**
	 * 获得每页的记录数量, 默认值为 1
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 获得页面内的记录列表
	 * 
	 * @return
	 */
	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	/**
	 * 获得总记录数, 默认值为 -1
	 * 
	 * @return
	 */
	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * 是否还有下一页
	 * 
	 * @return
	 */
	public boolean isHasNext() {
		return (pageNo + 1 <= getTotalPages());
	}

	/**
	 * 取得上一页页码
	 * 
	 * @return
	 */
	public int getNextPage() {
		if (isHasNext()) return pageNo + 1;
		else return pageNo;
	}

	/**
	 * 是否还有上一页
	 * 
	 * @return
	 */
	public boolean isHasPre() {
		return (pageNo - 1 >= 1);
	}

	/**
	 * 取得上页的页码, 序号从 1 开始 当前页为首页时返回首页序号
	 * 
	 * @return
	 */
	public int getPrePage() {
		if (isHasPre()) return pageNo - 1;
		else return pageNo;
	}

	/**
	 * 取当前页之前可以显示的页数，最多显示5页
	 * 
	 * @return
	 */
	public int getPreDisPages() {
		if (pageNo > 5) {
			return 5;
		} else {
			return (pageNo - 1);
		}
	}

	/**
	 * 取当前页后几页可以显示的页数，最多显示5页
	 * 
	 * @return
	 */
	public int getNextDisPages() {
		if (pageNo < totalPages - 5) {
			return 5;
		} else {
			return totalPages - pageNo;
		}
	}
}
