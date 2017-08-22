package com.cc.entity;

/**
 * config_attribute
 */
public class ConfigAttribute {

	/**
	   
	 */
	private Long attribute_id;
	
	/**
	   
	 */
	private Long config_id;
	
	/**
	   
	 */
	private String attribute_name;
	
	/**
	   
	 */
	private String attribute_value;
	
	/**
	   
	 */
	private String attribute_desc;
	
		
	//分页
	private Page page;
	
	
	
	public Long getAttributeId() {
		return attribute_id;
	}

	public void setAttributeId(Long attribute_id) {
		this.attribute_id = attribute_id;
	} 
	
	public Long getConfigId() {
		return config_id;
	}

	public void setConfigId(Long config_id) {
		this.config_id = config_id;
	} 
	
	public String getAttributeName() {
		return attribute_name;
	}

	public void setAttributeName(String attribute_name) {
		this.attribute_name = attribute_name;
	} 
	
	public String getAttributeValue() {
		return attribute_value;
	}

	public void setAttributeValue(String attribute_value) {
		this.attribute_value = attribute_value;
	} 
	
	public String getAttributeDesc() {
		return attribute_desc;
	}

	public void setAttributeDesc(String attribute_desc) {
		this.attribute_desc = attribute_desc;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
