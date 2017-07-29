package com.cc.mapper;
import java.util.*;
import com.cc.entity.Dota2Heros;
/**
 * dota2_heros
 */
public interface Dota2HerosMapper{
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<Dota2Heros> listPageDota2Heros(Dota2Heros dota2Heros);
	
	/**
	 *  获取Dota2Heros的数量
	 */
	public Integer getDota2HerosCount();
	
	
	public void insert(Dota2Heros dota2Heros);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(Dota2Heros dota2Heros);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(Dota2Heros dota2Heros);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public Dota2Heros getDota2HerosById(Integer id);
	
	/**
	 * 根据根据条件查询Dota2Heros 
	 */
	public List<Dota2Heros> listDota2Heros(Dota2Heros dota2Heros);  
	 
	 /**
	 * 更新Dota2Heros
	 */
	public void updateDota2Heros(Dota2Heros dota2Heros);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteDota2Heros(Dota2Heros dota2Heros);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteDota2HerosByIds (String[] id);
	
}