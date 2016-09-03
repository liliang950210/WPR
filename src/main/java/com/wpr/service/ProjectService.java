package com.wpr.service;

import java.util.List;

import com.wpr.entity.TProject;

/**
 * @author chuankunYi
 * email:yichuankun@qq.com
 *2016年9月1日 下午4:17:31
 */
public interface ProjectService {

	public void addProject(TProject tProject);
	public void updateProject(TProject tProject);
	
	/*
	 * 返回所有的项目
	 * @return
	 *chuankunYi
	 *email:yichuankun@qq.com
	 *2016年9月2日 下午5:53:41
	 */
	public List getAllProject();
	
	
	
}
