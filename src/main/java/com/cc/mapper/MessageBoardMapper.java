package com.cc.mapper;
import java.util.*;
import com.cc.entity.MessageBoard;
/**
 * message_board
 */
public interface MessageBoardMapper{
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<MessageBoard> listPageMessageBoard(MessageBoard messageBoard);
	
	/**
	 *  获取MessageBoard的数量
	 */
	public Integer getMessageBoardCount();
	
	
	public void insert(MessageBoard messageBoard);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(MessageBoard messageBoard);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(MessageBoard messageBoard);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public MessageBoard getMessageBoardById(Integer id);
	
	/**
	 * 根据根据条件查询MessageBoard 
	 */
	public List<MessageBoard> listMessageBoard(MessageBoard messageBoard);  
	 
	 /**
	 * 更新MessageBoard
	 */
	public void updateMessageBoard(MessageBoard messageBoard);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteMessageBoard(MessageBoard messageBoard);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteMessageBoardByIds (String[] id);
	
}