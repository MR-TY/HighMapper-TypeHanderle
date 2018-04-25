package com.ty.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ty.shop.entities.User;
import com.ty.shop.mappers.UserMapper;

@Service
@Transactional
public class UserService {
	@Autowired
	UserMapper userMapper;

	public void saveUser(User user) {
		userMapper.insert(user);
	}
	
	public List<User> selectAll(){
		return userMapper.selectAll();
	}
}
