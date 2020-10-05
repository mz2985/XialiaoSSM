package com.qf.service;

import java.util.ArrayList;

import com.qf.pojo.Publish;

public interface PublishService {
	public ArrayList<Publish> getAllPublish();

	public ArrayList<Publish> getNickPublish(String nickname);
	
	public boolean deletePublish(String sign);
	
	public boolean publishServlet(Publish publish);
}
