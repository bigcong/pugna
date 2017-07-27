package com.cc.dota2.entity;

import com.cc.entity.Page;

/**
 * dota2_match_details
 */
public class Dota2MatchDetails {

	/**
	   比赛id
	 */
	private Long matchId;
	
	/**
	   
	 */
	private String radiantWin;
	
	/**
	   
	 */
	private Short duration;
	
	/**
	   
	 */
	private String season;
	
	/**
	   
	 */
	private Integer startTime;
	
	/**
	   
	 */
	private Long matchSeqNum;
	
	/**
	   
	 */
	private Integer towerStatusRadiant;
	
	/**
	   
	 */
	private Integer towerStatusDire;
	
	/**
	   
	 */
	private Integer barracksStatusRadiant;
	
	/**
	   
	 */
	private Short barracksStatusDire;
	
	/**
	   
	 */
	private Short cluster;
	
	/**
	   
	 */
	private Short firstBloodTime;
	
	/**
	   
	 */
	private Integer lobbyType;
	
	/**
	   
	 */
	private Short humanPlayers;
	
	/**
	   
	 */
	private Short leagueid;
	
	/**
	   
	 */
	private Short positiveVotes;
	
	/**
	   
	 */
	private Short negativeVotes;
	
	/**
	   
	 */
	private Short gameMode;
	
	/**
	   
	 */
	private Integer flags;
	
	/**
	   
	 */
	private Integer engine;
	
	/**
	   
	 */
	private Integer radiantScore;
	
	/**
	   
	 */
	private Integer direScore;
	
	/**
	   
	 */
	private Integer radiantTeamId;
	
	/**
	   
	 */
	private String radiantName;
	
	/**
	   
	 */
	private Long radiantLogo;
	
	/**
	   
	 */
	private Short radiantTeamComplete;
	
	/**
	   
	 */
	private Short direTeamId;
	
	/**
	   
	 */
	private String direName;
	
	/**
	   
	 */
	private Long direLogo;
	
	/**
	   
	 */
	private Short direTeamComplete;
	
	/**
	   
	 */
	private Integer radiantCaptain;
	
	/**
	   
	 */
	private Integer direCaptain;
	
	/**
	   
	 */
	private String players;
	
	/**
	   
	 */
	private String picksBans;
	
		
	//分页
	private Page page;
	
	
	
	public Long getMatchId() {
		return matchId;
	}

	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	} 
	
	public String getRadiantWin() {
		return radiantWin;
	}

	public void setRadiantWin(String radiantWin) {
		this.radiantWin = radiantWin;
	} 
	
	public Short getDuration() {
		return duration;
	}

	public void setDuration(Short duration) {
		this.duration = duration;
	} 
	
	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	} 
	
	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	} 
	
	public Long getMatchSeqNum() {
		return matchSeqNum;
	}

	public void setMatchSeqNum(Long matchSeqNum) {
		this.matchSeqNum = matchSeqNum;
	} 
	
	public Integer getTowerStatusRadiant() {
		return towerStatusRadiant;
	}

	public void setTowerStatusRadiant(Integer towerStatusRadiant) {
		this.towerStatusRadiant = towerStatusRadiant;
	} 
	
	public Integer getTowerStatusDire() {
		return towerStatusDire;
	}

	public void setTowerStatusDire(Integer towerStatusDire) {
		this.towerStatusDire = towerStatusDire;
	} 
	
	public Integer getBarracksStatusRadiant() {
		return barracksStatusRadiant;
	}

	public void setBarracksStatusRadiant(Integer barracksStatusRadiant) {
		this.barracksStatusRadiant = barracksStatusRadiant;
	} 
	
	public Short getBarracksStatusDire() {
		return barracksStatusDire;
	}

	public void setBarracksStatusDire(Short barracksStatusDire) {
		this.barracksStatusDire = barracksStatusDire;
	} 
	
	public Short getCluster() {
		return cluster;
	}

	public void setCluster(Short cluster) {
		this.cluster = cluster;
	} 
	
	public Short getFirstBloodTime() {
		return firstBloodTime;
	}

	public void setFirstBloodTime(Short firstBloodTime) {
		this.firstBloodTime = firstBloodTime;
	} 
	
	public Integer getLobbyType() {
		return lobbyType;
	}

	public void setLobbyType(Integer lobbyType) {
		this.lobbyType = lobbyType;
	} 
	
	public Short getHumanPlayers() {
		return humanPlayers;
	}

	public void setHumanPlayers(Short humanPlayers) {
		this.humanPlayers = humanPlayers;
	} 
	
	public Short getLeagueid() {
		return leagueid;
	}

	public void setLeagueid(Short leagueid) {
		this.leagueid = leagueid;
	} 
	
	public Short getPositiveVotes() {
		return positiveVotes;
	}

	public void setPositiveVotes(Short positiveVotes) {
		this.positiveVotes = positiveVotes;
	} 
	
	public Short getNegativeVotes() {
		return negativeVotes;
	}

	public void setNegativeVotes(Short negativeVotes) {
		this.negativeVotes = negativeVotes;
	} 
	
	public Short getGameMode() {
		return gameMode;
	}

	public void setGameMode(Short gameMode) {
		this.gameMode = gameMode;
	} 
	
	public Integer getFlags() {
		return flags;
	}

	public void setFlags(Integer flags) {
		this.flags = flags;
	} 
	
	public Integer getEngine() {
		return engine;
	}

	public void setEngine(Integer engine) {
		this.engine = engine;
	} 
	
	public Integer getRadiantScore() {
		return radiantScore;
	}

	public void setRadiantScore(Integer radiantScore) {
		this.radiantScore = radiantScore;
	} 
	
	public Integer getDireScore() {
		return direScore;
	}

	public void setDireScore(Integer direScore) {
		this.direScore = direScore;
	} 
	
	public Integer getRadiantTeamId() {
		return radiantTeamId;
	}

	public void setRadiantTeamId(Integer radiantTeamId) {
		this.radiantTeamId = radiantTeamId;
	} 
	
	public String getRadiantName() {
		return radiantName;
	}

	public void setRadiantName(String radiantName) {
		this.radiantName = radiantName;
	} 
	
	public Long getRadiantLogo() {
		return radiantLogo;
	}

	public void setRadiantLogo(Long radiantLogo) {
		this.radiantLogo = radiantLogo;
	} 
	
	public Short getRadiantTeamComplete() {
		return radiantTeamComplete;
	}

	public void setRadiantTeamComplete(Short radiantTeamComplete) {
		this.radiantTeamComplete = radiantTeamComplete;
	} 
	
	public Short getDireTeamId() {
		return direTeamId;
	}

	public void setDireTeamId(Short direTeamId) {
		this.direTeamId = direTeamId;
	} 
	
	public String getDireName() {
		return direName;
	}

	public void setDireName(String direName) {
		this.direName = direName;
	} 
	
	public Long getDireLogo() {
		return direLogo;
	}

	public void setDireLogo(Long direLogo) {
		this.direLogo = direLogo;
	} 
	
	public Short getDireTeamComplete() {
		return direTeamComplete;
	}

	public void setDireTeamComplete(Short direTeamComplete) {
		this.direTeamComplete = direTeamComplete;
	} 
	
	public Integer getRadiantCaptain() {
		return radiantCaptain;
	}

	public void setRadiantCaptain(Integer radiantCaptain) {
		this.radiantCaptain = radiantCaptain;
	} 
	
	public Integer getDireCaptain() {
		return direCaptain;
	}

	public void setDireCaptain(Integer direCaptain) {
		this.direCaptain = direCaptain;
	} 
	
	public String getPlayers() {
		return players;
	}

	public void setPlayers(String players) {
		this.players = players;
	} 
	
	public String getPicksBans() {
		return picksBans;
	}

	public void setPicksBans(String picksBans) {
		this.picksBans = picksBans;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
