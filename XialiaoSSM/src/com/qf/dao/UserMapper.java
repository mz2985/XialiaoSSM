package com.qf.dao;

import java.util.ArrayList;

import com.qf.pojo.User;

public interface UserMapper {
	public ArrayList<User> userLogin(User user);

	public User checkRegisterUser(String username);

	public int userRegister(User user);
}
