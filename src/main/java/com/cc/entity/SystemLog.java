package com.cc.entity;

/**
 * system_log
 */
public class SystemLog {

	/**
	   主键
	 */
	private Integer logId;
	
	/**
	   日志内容
	 */
	private String logContent;
	
	/**
	   登录人
	 */
	private Integer userId;
	
	/**
	   日志日期
	 */
	private String logDate;
	
	/**
	   日志级别
	 */
	private Integer logLevel;
	
	/**
	   日志类型
	 */
	private String logType;
	
	/**
	   日志发生路径
	 */
	private String logUrl;
	
	/**
	   创建人
	 */
	private Integer createPeople;
	
	/**
	   日志创建日期
	 */
	private String createDate;
	
	/**
	   更新日期
	 */
	private String updateDate;
	
	/**
	   更新人
	 */
	private Integer updatePeople;
	
		
	//分页
	private Page page;
	
	
	
	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	} 
	
	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	} 
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	} 
	
	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	} 
	
	public Integer getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(Integer logLevel) {
		this.logLevel = logLevel;
	} 
	
	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	} 
	
	public String getLogUrl() {
		return logUrl;
	}

	public void setLogUrl(String logUrl) {
		this.logUrl = logUrl;
	} 
	
	public Integer getCreatePeople() {
		return createPeople;
	}

	public void setCreatePeople(Integer createPeople) {
		this.createPeople = createPeople;
	} 
	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	} 
	
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	} 
	
	public Integer getUpdatePeople() {
		return updatePeople;
	}

	public void setUpdatePeople(Integer updatePeople) {
		this.updatePeople = updatePeople;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
