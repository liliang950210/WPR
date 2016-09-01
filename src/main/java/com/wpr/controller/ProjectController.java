package com.wpr.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wpr.entity.TProject;
import com.wpr.service.ProjectService;
import com.wpr.util.Message;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Resource
	private ProjectService projectService;
	
	@RequestMapping("/addProject")
	@ResponseBody
	public Object addObject(String projectName,String projectDesc){
		TProject tProject = new TProject();
		tProject.setProjectName(projectName);
		tProject.setProjectDesc(projectDesc);
	
		projectService.addProject(tProject);
		System.out.println(tProject.getId());
		
		return Message.getMessage();
	}
	@RequestMapping("/updateProject")
	@ResponseBody
	public Object updateObject(){
		
	}
	

}
