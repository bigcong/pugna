package com.cc.dota2.service.impl;
import java.util.*;
import com.cc.dota2.mapper.Dota2MatchDetailsMapper;
import com.cc.dota2.entity.Dota2MatchDetails;
import com.cc.dota2.service.Dota2MatchDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * dota2_match_details
 */
@Service
public  class Dota2MatchDetailsServiceImpl implements Dota2MatchDetailsService{
    @Autowired
	private Dota2MatchDetailsMapper dota2MatchDetailsMapper;
	
	@Override
	public List<Dota2MatchDetails> listPageDota2MatchDetails(Dota2MatchDetails dota2MatchDetails){
		return dota2MatchDetailsMapper.listPageDota2MatchDetails(dota2MatchDetails);
	}
	
	@Override
	public Integer getDota2MatchDetailsCount(){
	    return dota2MatchDetailsMapper.getDota2MatchDetailsCount();
	}
	
	@Override
	public void insert(Dota2MatchDetails dota2MatchDetails){
	     dota2MatchDetailsMapper.insert(dota2MatchDetails);
	}
	
	@Override
	public Dota2MatchDetails getDota2MatchDetailsById(Integer id){
	    return dota2MatchDetailsMapper.getDota2MatchDetailsById(id);
	}
	
	@Override
	public List<Dota2MatchDetails> listDota2MatchDetails(Dota2MatchDetails dota2MatchDetails){
	    return dota2MatchDetailsMapper.listDota2MatchDetails(dota2MatchDetails);
	}  
	
	@Override
	public void updateDota2MatchDetails(Dota2MatchDetails dota2MatchDetails){
	     dota2MatchDetailsMapper.updateDota2MatchDetails(dota2MatchDetails);
	}
	
	@Override
	public void  deleteDota2MatchDetails(Dota2MatchDetails dota2MatchDetails){
	     dota2MatchDetailsMapper.deleteDota2MatchDetails(dota2MatchDetails);
	}
	
	@Override
	public void  deleteDota2MatchDetailsByIds (String[] ids){
	    dota2MatchDetailsMapper.deleteDota2MatchDetailsByIds(ids); 
	}
	
	@Override
	public void insertSelective(Dota2MatchDetails dota2MatchDetails){
	 dota2MatchDetailsMapper.insertSelective(dota2MatchDetails);
	}
	
	@Override
	public void updateByPrimaryKeySelective(Dota2MatchDetails dota2MatchDetails){
		 dota2MatchDetailsMapper.updateByPrimaryKeySelective(dota2MatchDetails);
	}
	
}