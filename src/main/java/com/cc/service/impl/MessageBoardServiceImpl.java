package com.cc.service.impl;
import java.util.*;
import com.cc.mapper.MessageBoardMapper;
import com.cc.entity.MessageBoard;
import com.cc.service.MessageBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * message_board
 */
@Service
public  class MessageBoardServiceImpl implements MessageBoardService{
    @Autowired
	private MessageBoardMapper messageBoardMapper;
	
	@Override
	public List<MessageBoard> listPageMessageBoard(MessageBoard messageBoard){
		return messageBoardMapper.listPageMessageBoard(messageBoard);
	}
	
	@Override
	public Integer getMessageBoardCount(){
	    return messageBoardMapper.getMessageBoardCount();
	}
	
	@Override
	public void insert(MessageBoard messageBoard){
	     messageBoardMapper.insert(messageBoard);
	}
	
	@Override
	public MessageBoard getMessageBoardById(Integer id){
	    return messageBoardMapper.getMessageBoardById(id);
	}
	
	@Override
	public List<MessageBoard> listMessageBoard(MessageBoard messageBoard){
	    return messageBoardMapper.listMessageBoard(messageBoard);
	}  
	
	@Override
	public void updateMessageBoard(MessageBoard messageBoard){
	     messageBoardMapper.updateMessageBoard(messageBoard);
	}
	
	@Override
	public void  deleteMessageBoard(MessageBoard messageBoard){
	     messageBoardMapper.deleteMessageBoard(messageBoard);
	}
	
	@Override
	public void  deleteMessageBoardByIds (String[] ids){
	    messageBoardMapper.deleteMessageBoardByIds(ids); 
	}
	
	@Override
	public void insertSelective(MessageBoard messageBoard){
	 messageBoardMapper.insertSelective(messageBoard);
	}
	
	@Override
	public void updateByPrimaryKeySelective(MessageBoard messageBoard){
		 messageBoardMapper.updateByPrimaryKeySelective(messageBoard);
	}
	
}