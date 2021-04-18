package com.k.action;

import java.util.Map;

import com.k.pojo.User;
import com.k.service.userService;
import com.k.service.impl.userServiceImpl;
import com.opensymphony.xwork2.ActionContext;


//action在每次调用的时候都会被实例化一次
public class userAction {
	static int number=0; //application域访问计数器
	private int count;
	private String userpassword;
	userService usservice=new userServiceImpl();
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String execute() {
		int error=0;
		
		User user=usservice.verifyCount(count, userpassword);
		if(user==null){
			System.out.println("验证失败");
		
			ActionContext.getContext().put("error", error);
			 return "error";
			 
		}
		number+=1;
	
		ActionContext.getContext().getSession().put("user",user);
		Map application=ActionContext.getContext().getApplication();
		application.put("number",number);
		return "success";
		
	 }
}
