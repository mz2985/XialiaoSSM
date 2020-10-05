package com.qf.dao;//dao层只做数据的查询和操作，关联数据库

import java.util.ArrayList;

import com.qf.pojo.Publish;

public interface PublishMapper {
	public ArrayList<Publish> getAllPublish();

	public ArrayList<Publish> getNickPublish(String nickname);
	
	public int deletePublish(String sign);
	
	public int publishServlet(Publish publish);
	
}
