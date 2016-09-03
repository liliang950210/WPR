package com.wpr.service.imp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wpr.dao.BDao;
import com.wpr.entity.TUser;
import com.wpr.service.UserService;
import com.wpr.util.Const;
import com.wpr.util.MD5;
import com.wpr.util.SessionTool;

/**
 * @author chuankunYi
 * email:yichuankun@qq.com
 *2016年9月2日 上午9:19:56
 */
@Service
public class UserServiceImp implements UserService {

	@Autowired
	private BDao<TUser>  bDao;

	public void addUser(TUser tUser) {
		// TODO Auto-generated method stub
		tUser.setPassword(MD5.GetMD5Code(tUser.getPassword()));
		bDao.save(tUser);
	}

	public int login(TUser tUser,HttpSession session) {
		// TODO Auto-generated method stub
		String hql = "  from TUser user where username = ?";
		Object[] obArray = {tUser.getUsername()};
		TUser user = bDao.get(hql, obArray);
		if(user==null){
			return 3;//用户不存
		}else if(user.getPassword().equals(MD5.GetMD5Code(tUser.getPassword()))){
			SessionTool.setValue(session, Const.USER_ID, user.getId());
			return 1; 
		}else{
			return 2;//密码错误
		}
	}

	public boolean isRegister(String username) {
		// TODO Auto-generated method stub
		String hql = "  from TUser where username = ?";
		Object[] obArray = {username};
		TUser user = bDao.get(hql, obArray);
		if(user==null){
			return false;
		}else{
			return true;
		}
	}
}
