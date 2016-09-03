package com.wpr.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wpr.entity.TReport;
import com.wpr.entity.TUser;
import com.wpr.service.ReportService;
import com.wpr.util.Const;
import com.wpr.util.Message;
import com.wpr.util.SessionTool;

/**
 * @author chuankunYi
 * email:yichuankun@qq.com
 *2016年9月3日 下午7:40:58
 */
@Controller
@RequestMapping("/report")
public class ReportController {

	@Resource
	private ReportService reportService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Object addReport(TReport report,HttpSession session ){
		if(report.getCompleted()==null||report.getPlan()==null){
			return Message.getMessageParmNull();
		}
		//先写死了
		 report.setProjectId(0);
		report.setUserId(SessionTool.getUserId(session, "userId"));
		report.setCompleteTime(new Date());
		reportService.addReport(report);
		
		return Message.getMessage();
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Object update(TReport report,HttpSession session){
		if(report.getCompleted()==null||report.getPlan()==null){
			return Message.getMessageParmNull();
		}
		report.setProjectId(0);
		report.setUserId(SessionTool.getUserId(session, "userId"));
		report.setCompleteTime(new Date());
		reportService.updateReport(report);
		
		return Message.getMessage();
	}
	@RequestMapping("/getAll")
	@ResponseBody
	public Object getAll(HttpSession session){
		
		//捕获取不到UserId的异常
		try{
		return Message.getMessage(reportService.getAllreport(SessionTool.getUserId(session, Const.USER_ID)));
		}catch (NullPointerException e){
			return Message.getMessage(3, "登录已失效,请重新登录", "");
		}
	}
	
}
