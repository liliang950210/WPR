package com.wpr.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wpr.entity.TUser;
import com.wpr.service.UserService;
import com.wpr.util.Message;

/**
 * @author chuankunYi
 * email:yichuankun@qq.com
 *2016年9月2日 上午9:55:49
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	@ResponseBody
	public Object register(String username,String password){
		if(username==null||password==null){
			return Message.getMessageParmNull();
		}
		TUser user = new TUser();
		user.setPassword(password);
		user.setUsername(username);
		if(userService.isRegister(username)){
			return Message.getMessage(2, "用户名已被注册", "");
		}else{
			user.setRegistTime(new Date());
			userService.addUser(user);
		}
		return Message.getMessage();
	}

	@RequestMapping(value="/isRegister",method=RequestMethod.GET)
	@ResponseBody
	public Object isRegsiter(String username){
		
		if(username==null){
			return Message.getMessageParmNull();
		}
		if(userService.isRegister(username)){
			return Message.getMessage(2, "用户名已被注册", "");
		}else{
			return Message.getMessage();
		}
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	@ResponseBody
	public Object login(TUser user,HttpSession session){
		if(user.getUsername()==null||user.getPassword()==null){
			return Message.getMessageParmNull();
		}
		int mark =  userService.login(user,session);
		if(mark == 1){
			return Message.getMessage();
		}else if(mark==2) {
			return Message.getMessage(2, "用户名或密码错误", "");
		}else{
			return Message.getMessage(3, "用户名不存在", "");
		}
		
	}
	
}
