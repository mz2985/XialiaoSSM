package com.qf.dao;//dao��ֻ�����ݵĲ�ѯ�Ͳ������������ݿ�

import java.util.ArrayList;

import com.qf.pojo.Publish;

public interface PublishMapper {
	public ArrayList<Publish> getAllPublish();

	public ArrayList<Publish> getNickPublish(String nickname);
	
	public int deletePublish(String sign);
	
	public int publishServlet(Publish publish);
	
}
