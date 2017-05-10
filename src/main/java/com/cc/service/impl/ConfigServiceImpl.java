package com.cc.service.impl;
import java.util.*;
import com.cc.mapper.ConfigMapper;
import com.cc.entity.Config;
import com.cc.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * config
 */
@Service
public  class ConfigServiceImpl implements ConfigService{
    @Autowired
	private ConfigMapper configMapper;
	
	@Override
	public List<Config> listPageConfig(Config config){
		return configMapper.listPageConfig(config);
	}
	
	@Override
	public Integer getConfigCount(){
	    return configMapper.getConfigCount();
	}
	
	@Override
	public void insert(Config config){
	     configMapper.insert(config);
	}
	
	@Override
	public Config getConfigById(Integer id){
	    return configMapper.getConfigById(id);
	}
	
	@Override
	public List<Config> listConfig(Config config){
	    return configMapper.listConfig(config);
	}  
	
	@Override
	public void updateConfig(Config config){
	     configMapper.updateConfig(config);
	}
	
	@Override
	public void  deleteConfig(Config config){
	     configMapper.deleteConfig(config);
	}
	
	@Override
	public void  deleteConfigByIds (String[] ids){
	    configMapper.deleteConfigByIds(ids); 
	}
	
	@Override
	public void insertSelective(Config config){
	 configMapper.insertSelective(config);
	}
	
	@Override
	public void updateByPrimaryKeySelective(Config config){
		 configMapper.updateByPrimaryKeySelective(config);
	}
	
}