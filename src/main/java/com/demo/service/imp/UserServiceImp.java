package com.demo.service.imp;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.entity.User;
import com.demo.service.UserService;
@Service
public class UserServiceImp implements UserService{
	
	@Resource
	private UserDao userDao;

	@Transactional
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}
	public User findUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}
