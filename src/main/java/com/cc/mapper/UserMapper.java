package com.cc.mapper;

import java.util.List;

import com.cc.entity.User;

public interface UserMapper {
	List<User> getUser(User user);

	List<User> getUserById(int userId);

	List<User> queryAllUser();

	int add(User user);

	int update(User user);

	void delete(int userId);

	List<User> listPageUser(User userSerach);

	List<User> query(User userSerach);

	int count(User userSerach);
}
