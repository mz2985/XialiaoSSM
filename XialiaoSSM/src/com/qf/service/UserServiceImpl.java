package com.qf.service;

import java.util.ArrayList;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.UserMapper;
import com.qf.pojo.User;
//标注业务层
@Service("userService")
public class UserServiceImpl implements UserService {
	
//	注入
	@Autowired
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	//重写
	@Override
	public ArrayList<User> userLogin(User user) {
		// TODO Auto-generated method stub
		return userMapper.userLogin(user);
	}
	@Override
	public User checkRegisterUser(String username) {
		// TODO Auto-generated method stub
		return userMapper.checkRegisterUser(username);
	}
	@Override
	public boolean userRegister(User user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int a = userMapper.userRegister(user);
		if (a>0) {
			flag = true;
		}
		return flag;
	}

}
