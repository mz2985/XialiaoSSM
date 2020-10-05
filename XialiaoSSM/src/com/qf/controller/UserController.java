package com.qf.controller;//servlet仅做前端的请求和相应关联前端

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.pojo.User;
import com.qf.service.UserService;

import net.sf.json.JSONArray;

//标注为springmvc的控制器
@Controller
public class UserController {
	public UserController(){
		System.out.println("userController");
	}
	
	@Resource(name="userService")
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
//	value 请求接口 method请求方式 produces返回类型
	@RequestMapping(value="/userLogin",method={RequestMethod.GET},produces="application/json;charset=utf-8")
	@ResponseBody
	public String userLogin(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		User user = new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		ArrayList<User> list = userService.userLogin(user);
		String userData = JSONArray.fromObject(list).toString();
		System.out.println(userData);
		return userData;
	}
	
	@RequestMapping(value="/userRegister",method={RequestMethod.POST},produces="application/json;charset=utf-8")
	@ResponseBody
	public String userRegister(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		User user = userService.checkRegisterUser(request.getParameter("username"));
		if(user != null){
			return "checked";
		}else{
			User user2 = new User();
			user2.setNickname(request.getParameter("nickname"));
			user2.setUsername(request.getParameter("username"));
			user2.setPassword(request.getParameter("password"));
			boolean isRegister = userService.userRegister(user2);
			if (isRegister) {
				return "success";
			} else {
				return "error";
			}
		}
	
	}
	
	
	
}
