package com.cc.entity;

/**
 * dota2_heros
 */
public class Dota2Heros {

	/**
	   
	 */
	private Short id;
	
	/**
	   
	 */
	private String name;
	
	/**
	   
	 */
	private String localized_name;
	
	/**
	   
	 */
	private String sb_png;
	
	/**
	   
	 */
	private String lg_png;
	
	/**
	   
	 */
	private String full_png;
	
	/**
	   
	 */
	private String vert_jpg;
	
		
	//分页
	private Page page;
	
	
	
	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	} 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	public String getLocalizedName() {
		return localized_name;
	}

	public void setLocalizedName(String localized_name) {
		this.localized_name = localized_name;
	} 
	
	public String getSbPng() {
		return sb_png;
	}

	public void setSbPng(String sb_png) {
		this.sb_png = sb_png;
	} 
	
	public String getLgPng() {
		return lg_png;
	}

	public void setLgPng(String lg_png) {
		this.lg_png = lg_png;
	} 
	
	public String getFullPng() {
		return full_png;
	}

	public void setFullPng(String full_png) {
		this.full_png = full_png;
	} 
	
	public String getVertJpg() {
		return vert_jpg;
	}

	public void setVertJpg(String vert_jpg) {
		this.vert_jpg = vert_jpg;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
