package com.wpr.service;

import java.util.List;

import com.wpr.entity.TReport;

/**
 * @author chuankunYi
 * email:yichuankun@qq.com
 *2016年9月3日 下午7:36:54
 */
public interface ReportService {

	
	public void addReport(TReport report);
	public void updateReport(TReport report);
	
	/*返回所有报告
	 * @param userId
	 * @return
	 *chuankunYi
	 *email:yichuankun@qq.com
	 *2016年9月3日 下午8:29:50
	 */
	public List getAllreport(int userId);
}
