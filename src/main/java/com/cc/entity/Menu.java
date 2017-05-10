package com.cc.entity;

/**
 * menu
 */
public class Menu {

	/**
	   菜单id
	 */
	private Integer menuId;
	
	/**
	   菜单名字
	 */
	private String menuName;
	
	/**
	   菜单url
	 */
	private String menuUrl;
	
	/**
	   修改时间
	 */
	private String updateTime;
	
	/**
	   修改人
	 */
	private String updatePerson;
	
	/**
	   更新人
	 */
	private Integer updatePersonId;
	
	/**
	   等级
	 */
	private Integer level;
	
	/**
	   父id
	 */
	private Integer pId;
	
	/**
	   是否锁住能否被删除修改
	 */
	private String isLocked;
	
	/**
	   是否可用
	 */
	private String enableFlag;
	
	/**
	   菜单排序
	 */
	private String menuSort;
	
		
	//分页
	private Page page;
	
	
	
	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	} 
	
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	} 
	
	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	} 
	
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	} 
	
	public String getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	} 
	
	public Integer getUpdatePersonId() {
		return updatePersonId;
	}

	public void setUpdatePersonId(Integer updatePersonId) {
		this.updatePersonId = updatePersonId;
	} 
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	} 
	
	public Integer getPId() {
		return pId;
	}

	public void setPId(Integer pId) {
		this.pId = pId;
	} 
	
	public String getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	} 
	
	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	} 
	
	public String getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(String menuSort) {
		this.menuSort = menuSort;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
