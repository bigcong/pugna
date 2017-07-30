package com.cc.mapper;
import java.util.*;
import com.cc.entity.Dota2GameItems;
/**
 * dota2_game_items
 */
public interface Dota2GameItemsMapper{
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<Dota2GameItems> listPageDota2GameItems(Dota2GameItems dota2GameItems);
	
	/**
	 *  获取Dota2GameItems的数量
	 */
	public Integer getDota2GameItemsCount();
	
	
	public void insert(Dota2GameItems dota2GameItems);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(Dota2GameItems dota2GameItems);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(Dota2GameItems dota2GameItems);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public Dota2GameItems getDota2GameItemsById(Integer id);
	
	/**
	 * 根据根据条件查询Dota2GameItems 
	 */
	public List<Dota2GameItems> listDota2GameItems(Dota2GameItems dota2GameItems);  
	 
	 /**
	 * 更新Dota2GameItems
	 */
	public void updateDota2GameItems(Dota2GameItems dota2GameItems);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteDota2GameItems(Dota2GameItems dota2GameItems);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteDota2GameItemsByIds (String[] id);
	
}