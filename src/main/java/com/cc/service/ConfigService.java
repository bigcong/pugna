package com.cc.service;
import java.util.*;
import com.cc.entity.Config;

/**
 * config
 */
public interface ConfigService{
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<Config> listPageConfig(Config config);
	
	/**
	 *  获取Config的数量
	 */
	public Integer getConfigCount();
	
	/**
	 *插入
	 */
	public void insert(Config config);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public Config getConfigById(Integer id);
	
	/**
	 * 根据根据条件查询Config 
	 */
	public List<Config> listConfig(Config config);  
	 
	 /**
	 * 更新Config
	 */
	public void updateConfig(Config config);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteConfig(Config config);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteConfigByIds (String[] ids);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(Config config);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(Config config);
	
}