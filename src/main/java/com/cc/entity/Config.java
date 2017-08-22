package com.cc.entity;

/**
 * config
 */
public class Config {

	/**
	   主键id
	 */
	private Integer config_id;
	
	/**
	   类型code
	 */
	private String config_type;
	
	/**
	   类型名称
	 */
	private String config_name;
	
	/**
	   值
	 */
	private String config_value;
	
	/**
	   是否启用
	 */
	private String config_status;
	
		
	//分页
	private Page page;
	
	
	
	public Integer getConfigId() {
		return config_id;
	}

	public void setConfigId(Integer config_id) {
		this.config_id = config_id;
	} 
	
	public String getConfigType() {
		return config_type;
	}

	public void setConfigType(String config_type) {
		this.config_type = config_type;
	} 
	
	public String getConfigName() {
		return config_name;
	}

	public void setConfigName(String config_name) {
		this.config_name = config_name;
	} 
	
	public String getConfigValue() {
		return config_value;
	}

	public void setConfigValue(String config_value) {
		this.config_value = config_value;
	} 
	
	public String getConfigStatus() {
		return config_status;
	}

	public void setConfigStatus(String config_status) {
		this.config_status = config_status;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
