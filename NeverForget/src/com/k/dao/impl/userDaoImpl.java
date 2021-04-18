package com.k.dao.impl;

import java.util.List;

import com.k.dao.userDao;
import com.k.pojo.User;
import com.k.util.BaseDao;

public class userDaoImpl extends BaseDao implements userDao {
	//单例模式的应用
	/*private static userDaoImpl userdaoinstance;
	 private userDaoImpl(){}

      public static synchronized userDaoImpl getInstance(){
            if(userdaoinstance ==null){
            	userdaoinstance = new userDaoImpl();
           }
            return userdaoinstance ;
     }
*/

	public User verifyCount(int count, String userpassword) {
		String preparedSql="select * from user where count=? and userpassword=?";
		Object[] param = {count,userpassword};
		//这里返回的是list集合,但肯定只有一条数据get(0);即使直接获取第一条数据
		User user=null;
		//因为如果什么也没查到,那就不能直接get(0)
		List<User> users=null;
		users=this.query(preparedSql, param, User.class);
			if(users!=null &&! users.isEmpty()) {
				
				user=users.get(0);
			}
		
		//如果查到,则user有数据,如果没有查到,则返回null
		return user;
		
	
	}

}
