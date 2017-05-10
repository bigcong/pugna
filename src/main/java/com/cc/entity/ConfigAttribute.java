package com.cc.entity;

/**
 * config_attribute
 */
public class ConfigAttribute {

	/**
	   主键
	 */
	private Long attributeId;
	
	/**
	   key 列名
	 */
	private String attributeKey;
	
	/**
	   列值
	 */
	private String attributeValue;
	
	/**
	   外键
	 */
	private Long configId;
	
	/**
	   key 的 中文描述
	 */
	private String attributeName;
	
		
	//分页
	private Page page;
	
	
	
	public Long getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(Long attributeId) {
		this.attributeId = attributeId;
	} 
	
	public String getAttributeKey() {
		return attributeKey;
	}

	public void setAttributeKey(String attributeKey) {
		this.attributeKey = attributeKey;
	} 
	
	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	} 
	
	public Long getConfigId() {
		return configId;
	}

	public void setConfigId(Long configId) {
		this.configId = configId;
	} 
	
	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
