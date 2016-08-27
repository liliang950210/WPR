package com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.service.UserService;
import com.demo.util.Message;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/addUser")
	@ResponseBody
	public Object addUser(String username,String password){
		System.out.println(username+password);
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		
		userService.addUser(user);
		
		return Message.getMessage();
	}
	

}
