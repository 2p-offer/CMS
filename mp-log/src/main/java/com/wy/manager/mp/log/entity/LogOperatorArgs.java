package com.wy.manager.mp.log.entity;


public class LogOperatorArgs {


	/**
	 * 平台名称
	 */
	private long id;

	/**
	 * 平台名称
	 */
	private long optime;

	/**
	 * 平台名称
	 */
	private String key;

	/**
	 * 平台名称
	 */
	private byte[] content;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOptime() {
		return optime;
	}

	public void setOptime(long optime) {
		this.optime = optime;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
}
