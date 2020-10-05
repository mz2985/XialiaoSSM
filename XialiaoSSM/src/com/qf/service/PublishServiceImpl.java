package com.qf.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.PublishMapper;
import com.qf.pojo.Publish;
import com.qf.pojo.User;

@Service("publishService")
public class PublishServiceImpl implements PublishService {
	
	@Autowired
	private PublishMapper publishMapper;

	public PublishMapper getPublishMapper() {
		return publishMapper;
	}
	public void setPublishMapper(PublishMapper publishMapper) {
		this.publishMapper = publishMapper;
	}


	@Override
	public ArrayList<Publish> getAllPublish() {
		// TODO Auto-generated method stub
		return publishMapper.getAllPublish();
	}
	@Override
	public ArrayList<Publish> getNickPublish(String nickname) {
		// TODO Auto-generated method stub
		return publishMapper.getNickPublish(nickname);
	}
	@Override
	public boolean deletePublish(String sign) {
		boolean flag = false;
		int a = publishMapper.deletePublish(sign);
		if (a>0) {
			flag = true;
		}
		
		return flag;
	}
	
	@Override
	public boolean publishServlet(Publish publish){
		boolean flag = false;
		int a = publishMapper.publishServlet(publish);
		if (a>0) {
			flag = true;
		}
		
		return flag;
	}
	
	
	

}
