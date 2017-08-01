package com.cc.mapper;
import java.util.*;
import com.cc.entity.Bills;
/**
 * bills
 */
public interface BillsMapper{
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<Bills> listPageBills(Bills bills);
	
	/**
	 *  获取Bills的数量
	 */
	public Integer getBillsCount();
	
	
	public void insert(Bills bills);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(Bills bills);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(Bills bills);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public Bills getBillsById(Integer id);
	
	/**
	 * 根据根据条件查询Bills 
	 */
	public List<Bills> listBills(Bills bills);  
	 
	 /**
	 * 更新Bills
	 */
	public void updateBills(Bills bills);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteBills(Bills bills);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteBillsByIds (String[] id);
	
}