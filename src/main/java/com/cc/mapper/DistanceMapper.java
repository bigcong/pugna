package com.cc.mapper;

import com.cc.entity.Distance;

import java.util.List;

/**
 * distance
 */
public interface DistanceMapper {
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<Distance> listPageDistance(Distance distance);
	
	/**
	 *  获取Distance的数量
	 */
	public Integer getDistanceCount();
	
	
	public void insert(Distance distance);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(Distance distance);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(Distance distance);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public Distance getDistanceById(String id);
	
	/**
	 * 根据根据条件查询Distance 
	 */
	public List<Distance> listDistance(Distance distance);  
	 
	 /**
	 * 更新Distance
	 */
	public void updateDistance(Distance distance);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteDistance(Distance distance);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteDistanceByIds(String[] id);
	
}