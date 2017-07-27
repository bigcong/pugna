package com.cc.entity;

/**
 * dota2_match_details
 */
public class Dota2MatchDetails {

	/**
	   比赛id
	 */
	private Long match_id;
	
	/**
	   
	 */
	private String radiant_win;
	
	/**
	   
	 */
	private Short duration;
	
	/**
	   
	 */
	private String season;
	
	/**
	   
	 */
	private Integer start_time;
	
	/**
	   
	 */
	private Long match_seq_num;
	
	/**
	   
	 */
	private Integer tower_status_radiant;
	
	/**
	   
	 */
	private Integer tower_status_dire;
	
	/**
	   
	 */
	private Integer barracks_status_radiant;
	
	/**
	   
	 */
	private Short barracks_status_dire;
	
	/**
	   
	 */
	private Short cluster;
	
	/**
	   
	 */
	private Short first_blood_time;
	
	/**
	   
	 */
	private Integer lobby_type;
	
	/**
	   
	 */
	private Short human_players;
	
	/**
	   
	 */
	private Short leagueid;
	
	/**
	   
	 */
	private Short positive_votes;
	
	/**
	   
	 */
	private Short negative_votes;
	
	/**
	   
	 */
	private Short game_mode;
	
	/**
	   
	 */
	private Integer flags;
	
	/**
	   
	 */
	private Integer engine;
	
	/**
	   
	 */
	private Integer radiant_score;
	
	/**
	   
	 */
	private Integer dire_score;
	
	/**
	   
	 */
	private Integer radiant_team_id;
	
	/**
	   
	 */
	private String radiant_name;
	
	/**
	   
	 */
	private Long radiant_logo;
	
	/**
	   
	 */
	private Short radiant_team_complete;
	
	/**
	   
	 */
	private Short dire_team_id;
	
	/**
	   
	 */
	private String dire_name;
	
	/**
	   
	 */
	private Long dire_logo;
	
	/**
	   
	 */
	private Short dire_team_complete;
	
	/**
	   
	 */
	private Integer radiant_captain;
	
	/**
	   
	 */
	private Integer dire_captain;
	
	/**
	   
	 */
	private String player;
	
	/**
	   
	 */
	private String picks_ban;
	
		
	//分页
	private Page page;
	
	
	
	public Long getMatchId() {
		return match_id;
	}

	public void setMatchId(Long match_id) {
		this.match_id = match_id;
	} 
	
	public String getRadiantWin() {
		return radiant_win;
	}

	public void setRadiantWin(String radiant_win) {
		this.radiant_win = radiant_win;
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
		return start_time;
	}

	public void setStartTime(Integer start_time) {
		this.start_time = start_time;
	} 
	
	public Long getMatchSeqNum() {
		return match_seq_num;
	}

	public void setMatchSeqNum(Long match_seq_num) {
		this.match_seq_num = match_seq_num;
	} 
	
	public Integer getTowerStatusRadiant() {
		return tower_status_radiant;
	}

	public void setTowerStatusRadiant(Integer tower_status_radiant) {
		this.tower_status_radiant = tower_status_radiant;
	} 
	
	public Integer getTowerStatusDire() {
		return tower_status_dire;
	}

	public void setTowerStatusDire(Integer tower_status_dire) {
		this.tower_status_dire = tower_status_dire;
	} 
	
	public Integer getBarracksStatusRadiant() {
		return barracks_status_radiant;
	}

	public void setBarracksStatusRadiant(Integer barracks_status_radiant) {
		this.barracks_status_radiant = barracks_status_radiant;
	} 
	
	public Short getBarracksStatusDire() {
		return barracks_status_dire;
	}

	public void setBarracksStatusDire(Short barracks_status_dire) {
		this.barracks_status_dire = barracks_status_dire;
	} 
	
	public Short getCluster() {
		return cluster;
	}

	public void setCluster(Short cluster) {
		this.cluster = cluster;
	} 
	
	public Short getFirstBloodTime() {
		return first_blood_time;
	}

	public void setFirstBloodTime(Short first_blood_time) {
		this.first_blood_time = first_blood_time;
	} 
	
	public Integer getLobbyType() {
		return lobby_type;
	}

	public void setLobbyType(Integer lobby_type) {
		this.lobby_type = lobby_type;
	} 
	
	public Short getHumanPlayers() {
		return human_players;
	}

	public void setHumanPlayers(Short human_players) {
		this.human_players = human_players;
	} 
	
	public Short getLeagueid() {
		return leagueid;
	}

	public void setLeagueid(Short leagueid) {
		this.leagueid = leagueid;
	} 
	
	public Short getPositiveVotes() {
		return positive_votes;
	}

	public void setPositiveVotes(Short positive_votes) {
		this.positive_votes = positive_votes;
	} 
	
	public Short getNegativeVotes() {
		return negative_votes;
	}

	public void setNegativeVotes(Short negative_votes) {
		this.negative_votes = negative_votes;
	} 
	
	public Short getGameMode() {
		return game_mode;
	}

	public void setGameMode(Short game_mode) {
		this.game_mode = game_mode;
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
		return radiant_score;
	}

	public void setRadiantScore(Integer radiant_score) {
		this.radiant_score = radiant_score;
	} 
	
	public Integer getDireScore() {
		return dire_score;
	}

	public void setDireScore(Integer dire_score) {
		this.dire_score = dire_score;
	} 
	
	public Integer getRadiantTeamId() {
		return radiant_team_id;
	}

	public void setRadiantTeamId(Integer radiant_team_id) {
		this.radiant_team_id = radiant_team_id;
	} 
	
	public String getRadiantName() {
		return radiant_name;
	}

	public void setRadiantName(String radiant_name) {
		this.radiant_name = radiant_name;
	} 
	
	public Long getRadiantLogo() {
		return radiant_logo;
	}

	public void setRadiantLogo(Long radiant_logo) {
		this.radiant_logo = radiant_logo;
	} 
	
	public Short getRadiantTeamComplete() {
		return radiant_team_complete;
	}

	public void setRadiantTeamComplete(Short radiant_team_complete) {
		this.radiant_team_complete = radiant_team_complete;
	} 
	
	public Short getDireTeamId() {
		return dire_team_id;
	}

	public void setDireTeamId(Short dire_team_id) {
		this.dire_team_id = dire_team_id;
	} 
	
	public String getDireName() {
		return dire_name;
	}

	public void setDireName(String dire_name) {
		this.dire_name = dire_name;
	} 
	
	public Long getDireLogo() {
		return dire_logo;
	}

	public void setDireLogo(Long dire_logo) {
		this.dire_logo = dire_logo;
	} 
	
	public Short getDireTeamComplete() {
		return dire_team_complete;
	}

	public void setDireTeamComplete(Short dire_team_complete) {
		this.dire_team_complete = dire_team_complete;
	} 
	
	public Integer getRadiantCaptain() {
		return radiant_captain;
	}

	public void setRadiantCaptain(Integer radiant_captain) {
		this.radiant_captain = radiant_captain;
	} 
	
	public Integer getDireCaptain() {
		return dire_captain;
	}

	public void setDireCaptain(Integer dire_captain) {
		this.dire_captain = dire_captain;
	} 
	
	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	} 
	
	public String getPicksBan() {
		return picks_ban;
	}

	public void setPicksBan(String picks_ban) {
		this.picks_ban = picks_ban;
	} 
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
}
