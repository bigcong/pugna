package com.cc.service.impl;
import java.util.*;
import com.cc.mapper.SystemLogMapper;
import com.cc.entity.SystemLog;
import com.cc.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * system_log
 */
@Service
public  class SystemLogServiceImpl implements SystemLogService{
    @Autowired
	private SystemLogMapper systemLogMapper;
	
	@Override
	public List<SystemLog> listPageSystemLog(SystemLog systemLog){
		return systemLogMapper.listPageSystemLog(systemLog);
	}
	
	@Override
	public Integer getSystemLogCount(){
	    return systemLogMapper.getSystemLogCount();
	}
	
	@Override
	public void insert(SystemLog systemLog){
	     systemLogMapper.insert(systemLog);
	}
	
	@Override
	public SystemLog getSystemLogById(Integer id){
	    return systemLogMapper.getSystemLogById(id);
	}
	
	@Override
	public List<SystemLog> listSystemLog(SystemLog systemLog){
	    return systemLogMapper.listSystemLog(systemLog);
	}  
	
	@Override
	public void updateSystemLog(SystemLog systemLog){
	     systemLogMapper.updateSystemLog(systemLog);
	}
	
	@Override
	public void  deleteSystemLog(SystemLog systemLog){
	     systemLogMapper.deleteSystemLog(systemLog);
	}
	
	@Override
	public void  deleteSystemLogByIds (String[] ids){
	    systemLogMapper.deleteSystemLogByIds(ids); 
	}
	
	@Override
	public void insertSelective(SystemLog systemLog){
	 systemLogMapper.insertSelective(systemLog);
	}
	
	@Override
	public void updateByPrimaryKeySelective(SystemLog systemLog){

		 systemLogMapper.updateByPrimaryKeySelective(systemLog);
	}
	
}