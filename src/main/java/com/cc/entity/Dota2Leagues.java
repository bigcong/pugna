package com.cc.entity;

/**
 * dota2_leagues
 */
public class Dota2Leagues {

	/**
	   
	 */
	private Integer leagueid;
	
	/**
	   
	 */
	private String name;
	
	/**
	   
	 */
	private String description;
	
	/**
	   
	 */
	private String tournament_url;
	
	/**
	   
	 */
	private Short itemdef;
	
		
	//分页
	private Page page;
	
	
	
	public Integer getLeagueid() {
		return leagueid;
	}

	public void setLeagueid(Integer leagueid) {
		this.leagueid = leagueid;
	} 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 
	
	public String getTournamentUrl() {
		return tournament_url;
	}

	public void setTournamentUrl(String tournament_url) {
		this.tournament_url = tournament_url;
	} 
	
	public Short getItemdef() {
		return itemdef;
	}

	public void setItemdef(Short itemdef) {
		this.itemdef = itemdef;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
