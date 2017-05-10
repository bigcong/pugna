package com.cc.mapper;
import java.util.*;
import com.cc.entity.TransactionRecord;
/**
 * transaction_record
 */
public interface TransactionRecordMapper{
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<TransactionRecord> listPageTransactionRecord(TransactionRecord transactionRecord);
	
	/**
	 *  获取TransactionRecord的数量
	 */
	public Integer getTransactionRecordCount();
	
	
	public void insert(TransactionRecord transactionRecord);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(TransactionRecord transactionRecord);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(TransactionRecord transactionRecord);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public TransactionRecord getTransactionRecordById(String id);
	
	/**
	 * 根据根据条件查询TransactionRecord 
	 */
	public List<TransactionRecord> listTransactionRecord(TransactionRecord transactionRecord);  
	 
	 /**
	 * 更新TransactionRecord
	 */
	public void updateTransactionRecord(TransactionRecord transactionRecord);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteTransactionRecord(TransactionRecord transactionRecord);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteTransactionRecordByIds (String[] id);
	
}