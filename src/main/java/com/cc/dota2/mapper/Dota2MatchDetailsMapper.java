package com.cc.dota2.mapper;
import java.util.*;
import com.cc.dota2.entity.Dota2MatchDetails;
/**
 * dota2_match_details
 */
public interface Dota2MatchDetailsMapper{
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<Dota2MatchDetails> listPageDota2MatchDetails(Dota2MatchDetails dota2MatchDetails);
	
	/**
	 *  获取Dota2MatchDetails的数量
	 */
	public Integer getDota2MatchDetailsCount();
	
	
	public void insert(Dota2MatchDetails dota2MatchDetails);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(Dota2MatchDetails dota2MatchDetails);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(Dota2MatchDetails dota2MatchDetails);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public Dota2MatchDetails getDota2MatchDetailsById(Integer id);
	
	/**
	 * 根据根据条件查询Dota2MatchDetails 
	 */
	public List<Dota2MatchDetails> listDota2MatchDetails(Dota2MatchDetails dota2MatchDetails);  
	 
	 /**
	 * 更新Dota2MatchDetails
	 */
	public void updateDota2MatchDetails(Dota2MatchDetails dota2MatchDetails);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteDota2MatchDetails(Dota2MatchDetails dota2MatchDetails);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteDota2MatchDetailsByIds (String[] id);
	
}