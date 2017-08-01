package com.cc.service.impl;
import java.util.*;
import com.cc.mapper.BillsMapper;
import com.cc.entity.Bills;
import com.cc.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * bills
 */
@Service
public  class BillsServiceImpl implements BillsService{
    @Autowired
	private BillsMapper billsMapper;
	
	@Override
	public List<Bills> listPageBills(Bills bills){
		return billsMapper.listPageBills(bills);
	}
	
	@Override
	public Integer getBillsCount(){
	    return billsMapper.getBillsCount();
	}
	
	@Override
	@Async
	public void insert(Bills bills){
	     billsMapper.insert(bills);
	}
	
	@Override
	public Bills getBillsById(Integer id){
	    return billsMapper.getBillsById(id);
	}
	
	@Override
	public List<Bills> listBills(Bills bills){
	    return billsMapper.listBills(bills);
	}  
	
	@Override
	public void updateBills(Bills bills){
	     billsMapper.updateBills(bills);
	}
	
	@Override
	public void  deleteBills(Bills bills){
	     billsMapper.deleteBills(bills);
	}
	
	@Override
	public void  deleteBillsByIds (String[] ids){
	    billsMapper.deleteBillsByIds(ids); 
	}
	
	@Override
	public void insertSelective(Bills bills){
	 billsMapper.insertSelective(bills);
	}
	
	@Override
	public void updateByPrimaryKeySelective(Bills bills){
		 billsMapper.updateByPrimaryKeySelective(bills);
	}
	
}