package com.wpr.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wpr.dao.BDao;
import com.wpr.entity.TReport;
import com.wpr.service.ReportService;

/**
 * @author chuankunYi
 * email:yichuankun@qq.com
 *2016年9月3日 下午7:38:43
 */
@Service
public class ReportServiceImp implements ReportService{

	@Resource
	private BDao<TReport> bDao;
	
	public void addReport(TReport report) {
		// TODO Auto-generated method stub
		bDao.save(report);
	}

	public void updateReport(TReport report) {
		// TODO Auto-generated method stub
		bDao.update(report);
	}

	public List getAllreport(int userId) throws NullPointerException{
		// TODO Auto-generated method stub
		String hql = "from TReport where userId = ?";
		Object [] object = {userId};
		System.out.println(userId);
		List resultList = bDao.find(hql, object);
		return resultList;
	}

}
