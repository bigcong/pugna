package com.cc.mapper;
import java.util.*;
import com.cc.entity.Dota2Leagues;
/**
 * dota2_leagues
 */
public interface Dota2LeaguesMapper{
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<Dota2Leagues> listPageDota2Leagues(Dota2Leagues dota2Leagues);
	
	/**
	 *  获取Dota2Leagues的数量
	 */
	public Integer getDota2LeaguesCount();
	
	
	public void insert(Dota2Leagues dota2Leagues);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(Dota2Leagues dota2Leagues);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(Dota2Leagues dota2Leagues);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public Dota2Leagues getDota2LeaguesById(Integer id);
	
	/**
	 * 根据根据条件查询Dota2Leagues 
	 */
	public List<Dota2Leagues> listDota2Leagues(Dota2Leagues dota2Leagues);  
	 
	 /**
	 * 更新Dota2Leagues
	 */
	public void updateDota2Leagues(Dota2Leagues dota2Leagues);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteDota2Leagues(Dota2Leagues dota2Leagues);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteDota2LeaguesByIds (String[] id);
	
}