package com.cc.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * config
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Config {

	/**
	   主键自增
	 */
	private Long configId;
	
	/**
	   
	 */
	private String type;
	
	/**
	   type  中文描述
	 */
	private String typeName;
	
	/**
	   value 中文描述
	 */
	private String valueName;
	
	/**
	   
	 */
	private String value;
	
		
	//分页
	private Page page;
	
	
	
	public Long getConfigId() {
		return configId;
	}

	public void setConfigId(Long configId) {
		this.configId = configId;
	} 
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	} 
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	} 
	
	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	} 
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
