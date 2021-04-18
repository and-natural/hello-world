package com.k.service.impl;



import com.k.dao.userDao;
import com.k.dao.impl.userDaoImpl;
import com.k.pojo.User;
import com.k.service.userService;

public class userServiceImpl  implements userService{
	private userDao userdimpl=new userDaoImpl();
		//	userDaoImpl.getInstance();
	
	public User verifyCount(int count, String userpassword) {
		
		if(count==0) {
			System.out.println("账户不合法,不予验证!");
			return null;
		}
		User  us=userdimpl.verifyCount(count, userpassword);
		
		return us;
	}

}
