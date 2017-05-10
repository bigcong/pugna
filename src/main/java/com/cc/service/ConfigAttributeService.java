package com.cc.service;
import java.util.*;
import com.cc.entity.ConfigAttribute;

/**
 * config_attribute
 */
public interface ConfigAttributeService{
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<ConfigAttribute> listPageConfigAttribute(ConfigAttribute configAttribute);
	
	/**
	 *  获取ConfigAttribute的数量
	 */
	public Integer getConfigAttributeCount();
	
	/**
	 *插入
	 */
	public void insert(ConfigAttribute configAttribute);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public ConfigAttribute getConfigAttributeById(Integer id);
	
	/**
	 * 根据根据条件查询ConfigAttribute 
	 */
	public List<ConfigAttribute> listConfigAttribute(ConfigAttribute configAttribute);  
	 
	 /**
	 * 更新ConfigAttribute
	 */
	public void updateConfigAttribute(ConfigAttribute configAttribute);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteConfigAttribute(ConfigAttribute configAttribute);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteConfigAttributeByIds (String[] ids);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(ConfigAttribute configAttribute);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(ConfigAttribute configAttribute);
	
}