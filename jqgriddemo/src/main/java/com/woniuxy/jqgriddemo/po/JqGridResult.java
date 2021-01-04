package com.woniuxy.jqgriddemo.po;

import java.util.List;

/**
 * 通用返回jqGrid的数据格式模型
 */
public class JqGridResult<T> {
	
	private int page;			// 当前页数
	private int total;			// 总页数	
	private long records;		// 总记录数
	private List<T> rows;		// 每行显示的内容
	private Object userdata;	// 用户自定义数据
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public long getRecords() {
		return records;
	}
	public void setRecords(long records) {
		this.records = records;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public Object getUserdata() {
		return userdata;
	}
	public void setUserdata(Object userdata) {
		this.userdata = userdata;
	}

	@Override
	public String toString() {
		return "JqGridResult{" +
				"page=" + page +
				", total=" + total +
				", records=" + records +
				", rows=" + rows +
				", userdata=" + userdata +
				'}';
	}
}
