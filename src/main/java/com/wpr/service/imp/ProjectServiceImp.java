package com.wpr.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpr.dao.BDao;
import com.wpr.entity.TProject;
import com.wpr.service.ProjectService;

/**
 * @author chuankunYi
 * email:yichuankun@qq.com
 *2016年9月1日 下午4:46:27
 */
@Service
public class ProjectServiceImp implements ProjectService{
	
	@Autowired
	private BDao< TProject> bDao;

	public void addProject(TProject tProject) {
		// TODO Auto-generated method stub
		bDao.save(tProject);
	}

	public void updateProject(TProject tProject) {
		// TODO Auto-generated method stub
		bDao.update(tProject);
	}

	public List getAllProject() {
		// TODO Auto-generated method stub
		String hql = "from TProject";
		List resultList = bDao.find(hql);
		
		return resultList;
	}
	

}
