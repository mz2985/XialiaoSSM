package com.qf.service;//serviceÒµÎñÂß¼­²ã

import java.util.ArrayList;

import com.qf.pojo.User;

public interface UserService {
	public ArrayList<User> userLogin(User user);

	public User checkRegisterUser(String username);

	public boolean userRegister(User user);
	
}
