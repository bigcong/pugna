package com.cc.mapper;
import java.util.*;
import com.cc.entity.Currency;
/**
 * currency
 */
public interface CurrencyMapper{
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<Currency> listPageCurrency(Currency currency);
	
	/**
	 *  获取Currency的数量
	 */
	public Integer getCurrencyCount();
	
	
	public void insert(Currency currency);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(Currency currency);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(Currency currency);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public Currency getCurrencyById(Integer id);
	
	/**
	 * 根据根据条件查询Currency 
	 */
	public List<Currency> listCurrency(Currency currency);  
	 
	 /**
	 * 更新Currency
	 */
	public void updateCurrency(Currency currency);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteCurrency(Currency currency);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteCurrencyByIds (String[] id);
	
}