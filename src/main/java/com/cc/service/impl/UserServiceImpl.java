package com.cc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cc.entity.User;
import com.cc.mapper.UserMapper;
import com.cc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public List<User> listPageUser(User user) {
		return this.userMapper.listPageUser(user);
	}

	public Integer getUserCount() {
		return 0;
	}

	public Integer insert(User user) {
		return this.userMapper.add(user);
	}

	public User getUserById(Integer id) {

		List<User> list = userMapper.getUserById(id);
		if (list.isEmpty()) {
			return list.get(0);
		} else {
			return new User();
		}

	}

	public User getUser(User user) {
		return this.userMapper.getUser(user).get(0);
	}

	public void updateUser(User User) {
		this.userMapper.update(User);
	}

	public void deleteUser(User User) {

	}

	public void deleteUserByIds(String[] ids) {
	}

	@Override
	public Integer insertUser(User paramUser) {
		// TODO Auto-generated method stub
		return null;
	}

}