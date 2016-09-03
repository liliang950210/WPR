package com.wpr.service;

import javax.servlet.http.HttpSession;

import com.wpr.entity.TUser;

/**
 * @author chuankunYi
 * email:yichuankun@qq.com
 *2016年9月2日 上午9:16:37
 */
public interface UserService {

	public void addUser(TUser tUser);
	
	
	/*
	 * @param tUser
	 * @return 1 表示登陆成功，2 表示密码错误 3 表示此用户不存在
	 *chuankunYi
	 *email:yichuankun@qq.com
	 *2016年9月2日 上午9:36:04
	 */
	public int login(TUser tUser,HttpSession session);
	
	/*
	 * 判断名字是否已被注册
	 * @param username
	 * @return
	 *chuankunYi
	 *email:yichuankun@qq.com
	 *2016年9月2日 上午9:18:33
	 */
	public boolean isRegister(String username);
	
}
