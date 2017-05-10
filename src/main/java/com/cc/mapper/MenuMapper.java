package com.cc.mapper;
import java.util.*;
import com.cc.entity.Menu;
/**
 * menu
 */
public interface MenuMapper{
   
	
	/**
	 * 根据条件 查询全部listPageAccount
	 */
	 
	public List<Menu> listPageMenu(Menu menu);
	
	/**
	 *  获取Menu的数量
	 */
	public Integer getMenuCount();
	
	
	public void insert(Menu menu);
	/**
	 *有条件的更新
	 */
	
	public void insertSelective(Menu menu);
	/**
	 *根据主键有条件的更新
	 */
	
	public void updateByPrimaryKeySelective(Menu menu);
	
	/**
	 * 根据主键查询(唯一)
	 */
	public Menu getMenuById(Integer id);
	
	/**
	 * 根据根据条件查询Menu 
	 */
	public List<Menu> listMenu(Menu menu);  
	 
	 /**
	 * 更新Menu
	 */
	public void updateMenu(Menu menu);
	
	 /**
	 * 很据实体类删除
	 */
	
	public void  deleteMenu(Menu menu);
	
	 /**
	 * 根据主键删除
	 */
	public void  deleteMenuByIds (String[] id);
	
}