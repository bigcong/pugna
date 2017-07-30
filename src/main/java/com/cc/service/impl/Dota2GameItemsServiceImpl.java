package com.cc.service.impl;
import java.util.*;
import com.cc.mapper.Dota2GameItemsMapper;
import com.cc.entity.Dota2GameItems;
import com.cc.service.Dota2GameItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * dota2_game_items
 */
@Service
public  class Dota2GameItemsServiceImpl implements Dota2GameItemsService{
    @Autowired
	private Dota2GameItemsMapper dota2GameItemsMapper;
	
	@Override
	public List<Dota2GameItems> listPageDota2GameItems(Dota2GameItems dota2GameItems){
		return dota2GameItemsMapper.listPageDota2GameItems(dota2GameItems);
	}
	
	@Override
	public Integer getDota2GameItemsCount(){
	    return dota2GameItemsMapper.getDota2GameItemsCount();
	}
	
	@Override
	public void insert(Dota2GameItems dota2GameItems){
	     dota2GameItemsMapper.insert(dota2GameItems);
	}
	
	@Override
	public Dota2GameItems getDota2GameItemsById(Integer id){
	    return dota2GameItemsMapper.getDota2GameItemsById(id);
	}
	
	@Override
	public List<Dota2GameItems> listDota2GameItems(Dota2GameItems dota2GameItems){
	    return dota2GameItemsMapper.listDota2GameItems(dota2GameItems);
	}  
	
	@Override
	public void updateDota2GameItems(Dota2GameItems dota2GameItems){
	     dota2GameItemsMapper.updateDota2GameItems(dota2GameItems);
	}
	
	@Override
	public void  deleteDota2GameItems(Dota2GameItems dota2GameItems){
	     dota2GameItemsMapper.deleteDota2GameItems(dota2GameItems);
	}
	
	@Override
	public void  deleteDota2GameItemsByIds (String[] ids){
	    dota2GameItemsMapper.deleteDota2GameItemsByIds(ids); 
	}
	
	@Override
	public void insertSelective(Dota2GameItems dota2GameItems){
	 dota2GameItemsMapper.insertSelective(dota2GameItems);
	}
	
	@Override
	public void updateByPrimaryKeySelective(Dota2GameItems dota2GameItems){
		 dota2GameItemsMapper.updateByPrimaryKeySelective(dota2GameItems);
	}
	
}