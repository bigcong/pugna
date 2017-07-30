package com.cc.entity;

/**
 * dota2_game_items
 */
public class Dota2GameItems {

	/**
	   
	 */
	private Short id;
	
	/**
	   
	 */
	private String name;
	
	/**
	   
	 */
	private Short cost;
	
	/**
	   
	 */
	private Integer secret_shop;
	
	/**
	   
	 */
	private Integer side_shop;
	
	/**
	   
	 */
	private Integer recipe;
	
	/**
	   
	 */
	private String localized_name;
	
		
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
	
	public Short getCost() {
		return cost;
	}

	public void setCost(Short cost) {
		this.cost = cost;
	} 
	
	public Integer getSecretShop() {
		return secret_shop;
	}

	public void setSecretShop(Integer secret_shop) {
		this.secret_shop = secret_shop;
	} 
	
	public Integer getSideShop() {
		return side_shop;
	}

	public void setSideShop(Integer side_shop) {
		this.side_shop = side_shop;
	} 
	
	public Integer getRecipe() {
		return recipe;
	}

	public void setRecipe(Integer recipe) {
		this.recipe = recipe;
	} 
	
	public String getLocalizedName() {
		return localized_name;
	}

	public void setLocalizedName(String localized_name) {
		this.localized_name = localized_name;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
