package com.demo.dao.imp;


import java.util.List;

import javax.transaction.Transactional;

import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.dao.UserDao;
import com.demo.entity.User;
@Repository
@SuppressWarnings("all")
public class UserDaoImp implements UserDao{
	
	 @Autowired
	private SessionFactory sessionFactory;
	
	 
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory( ){
		return this.sessionFactory;
	}
	
	public Session getCurrentSession(){
		if(sessionFactory==null){
			System.out.println("我空了");
		}
		return this.sessionFactory.getCurrentSession();
	}

	 
	public void addUser(User user) {
		// TODO Auto-generated method stub
		 this.getCurrentSession().save(user);
		 getUser(user);
		 
	}

	public void getUser(User user) {
		// TODO Auto-generated method stub
		String hql = "from User";
		Session session = getCurrentSession();
		try{
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		System.out.println(list.size()+">>>>>>>>>>>>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
