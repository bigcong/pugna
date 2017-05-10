package com.cc.service.impl;
import java.util.*;
import com.cc.mapper.ConfigAttributeMapper;
import com.cc.entity.ConfigAttribute;
import com.cc.service.ConfigAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * config_attribute
 */
@Service
public  class ConfigAttributeServiceImpl implements ConfigAttributeService{
    @Autowired
	private ConfigAttributeMapper configAttributeMapper;
	
	@Override
	public List<ConfigAttribute> listPageConfigAttribute(ConfigAttribute configAttribute){
		return configAttributeMapper.listPageConfigAttribute(configAttribute);
	}
	
	@Override
	public Integer getConfigAttributeCount(){
	    return configAttributeMapper.getConfigAttributeCount();
	}
	
	@Override
	public void insert(ConfigAttribute configAttribute){
	     configAttributeMapper.insert(configAttribute);
	}
	
	@Override
	public ConfigAttribute getConfigAttributeById(Integer id){
	    return configAttributeMapper.getConfigAttributeById(id);
	}
	
	@Override
	public List<ConfigAttribute> listConfigAttribute(ConfigAttribute configAttribute){
	    return configAttributeMapper.listConfigAttribute(configAttribute);
	}  
	
	@Override
	public void updateConfigAttribute(ConfigAttribute configAttribute){
	     configAttributeMapper.updateConfigAttribute(configAttribute);
	}
	
	@Override
	public void  deleteConfigAttribute(ConfigAttribute configAttribute){
	     configAttributeMapper.deleteConfigAttribute(configAttribute);
	}
	
	@Override
	public void  deleteConfigAttributeByIds (String[] ids){
	    configAttributeMapper.deleteConfigAttributeByIds(ids); 
	}
	
	@Override
	public void insertSelective(ConfigAttribute configAttribute){
	 configAttributeMapper.insertSelective(configAttribute);
	}
	
	@Override
	public void updateByPrimaryKeySelective(ConfigAttribute configAttribute){
		 configAttributeMapper.updateByPrimaryKeySelective(configAttribute);
	}
	
}