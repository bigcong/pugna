package com.cc.service.impl;
import java.util.*;
import com.cc.mapper.Dota2LeaguesMapper;
import com.cc.entity.Dota2Leagues;
import com.cc.service.Dota2LeaguesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * dota2_leagues
 */
@Service
public  class Dota2LeaguesServiceImpl implements Dota2LeaguesService{
    @Autowired
	private Dota2LeaguesMapper dota2LeaguesMapper;
	
	@Override
	public List<Dota2Leagues> listPageDota2Leagues(Dota2Leagues dota2Leagues){
		return dota2LeaguesMapper.listPageDota2Leagues(dota2Leagues);
	}
	
	@Override
	public Integer getDota2LeaguesCount(){
	    return dota2LeaguesMapper.getDota2LeaguesCount();
	}
	
	@Override
	public void insert(Dota2Leagues dota2Leagues){
	     dota2LeaguesMapper.insert(dota2Leagues);
	}
	
	@Override
	public Dota2Leagues getDota2LeaguesById(Integer id){
	    return dota2LeaguesMapper.getDota2LeaguesById(id);
	}
	
	@Override
	public List<Dota2Leagues> listDota2Leagues(Dota2Leagues dota2Leagues){
	    return dota2LeaguesMapper.listDota2Leagues(dota2Leagues);
	}  
	
	@Override
	public void updateDota2Leagues(Dota2Leagues dota2Leagues){
	     dota2LeaguesMapper.updateDota2Leagues(dota2Leagues);
	}
	
	@Override
	public void  deleteDota2Leagues(Dota2Leagues dota2Leagues){
	     dota2LeaguesMapper.deleteDota2Leagues(dota2Leagues);
	}
	
	@Override
	public void  deleteDota2LeaguesByIds (String[] ids){
	    dota2LeaguesMapper.deleteDota2LeaguesByIds(ids); 
	}
	
	@Override
	public void insertSelective(Dota2Leagues dota2Leagues){
	 dota2LeaguesMapper.insertSelective(dota2Leagues);
	}
	
	@Override
	public void updateByPrimaryKeySelective(Dota2Leagues dota2Leagues){
		 dota2LeaguesMapper.updateByPrimaryKeySelective(dota2Leagues);
	}
	
}