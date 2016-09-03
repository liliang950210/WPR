package com.wpr.util;

import javax.servlet.http.HttpSession;

/**
 * @author chuankunYi
 * email:yichuankun@qq.com
 *2016年9月3日 下午7:47:29
 */
public class SessionTool {
	
	/*
	 * 向session中插入值
	 * @param session
	 * @param key
	 * @param ob
	 *chuankunYi
	 *email:yichuankun@qq.com
	 *2016年9月3日 下午7:49:50
	 */
	public static void setValue(HttpSession session,String key,Object ob){
		
		session.setAttribute(key, ob);
	}
	/*
	 * 返回值
	 * @param session
	 * @param key
	 * @return
	 *chuankunYi
	 *email:yichuankun@qq.com
	 *2016年9月3日 下午7:52:41
	 */
	public static Object getValue(HttpSession session,String key){
		
		return session.getAttribute(key);
	}
	/*
	 * 返回系统的
	 * @param session
	 * @param key
	 * @return
	 *chuankunYi
	 *email:yichuankun@qq.com
	 *2016年9月3日 下午8:24:07
	 */
	public static int getUserId(HttpSession session,String key){
		return Integer.valueOf(session.getAttribute(key).toString());
	}

}
