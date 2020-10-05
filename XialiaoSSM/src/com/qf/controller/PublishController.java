package com.qf.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.pojo.Publish;
import com.qf.pojo.User;
import com.qf.service.PublishService;

import net.sf.json.JSONArray;

@Controller
public class PublishController {
	public PublishController(){
		System.out.println("publishController");
	}
	
	@Resource(name="publishService")
	private PublishService publishService;

	public PublishService getPublishService() {
		return publishService;
	}

	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	
	@RequestMapping(value="/getAllPublish",method={RequestMethod.GET},produces="application/json;charset=utf-8")
	@ResponseBody
	public String getAllPublish(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		ArrayList<Publish> list = publishService.getAllPublish();
		String aData = JSONArray.fromObject(list).toString();
		return aData;
	}
	
	@RequestMapping(value="/getNickPublish",method={RequestMethod.GET},produces="application/json;charset=utf-8")
	@ResponseBody
	public String getNickPublish(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		ArrayList<Publish> list = publishService.getNickPublish(request.getParameter("nickname"));
		String aData = JSONArray.fromObject(list).toString();
		return aData;
	}
	
	@RequestMapping(value="/deletePublish",method={RequestMethod.GET},produces="application/json;charset=utf-8")
	@ResponseBody
	public String deletePublish(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		boolean isDelete = publishService.deletePublish(request.getParameter("sign"));
		if (isDelete) {
			return "success";
		} else {
			return "error";
		}
	}
	
	
	
	@RequestMapping(value="/publishServlet",method={RequestMethod.POST},produces="application/json;charset=utf-8")
	@ResponseBody
	public String publishServlet(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		Publish publish2= new Publish();
		publish2.setDate(request.getParameter("date"));
		publish2.setNickname(request.getParameter("nickname"));
		publish2.setContent_txt(request.getParameter("content_txt"));
		publish2.setContent_img(request.getParameter("content_img"));
		publish2.setSign(request.getParameter("sign"));
		boolean isadd = publishService.publishServlet(publish2);
		
		if (isadd) {
			
			return "success";
		} else {
			return "error";
		}
	}
		
}











