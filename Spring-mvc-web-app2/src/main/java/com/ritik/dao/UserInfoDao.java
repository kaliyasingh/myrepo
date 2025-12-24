package com.ritik.dao;

import com.ritik.pojo.UserInfo;

public interface UserInfoDao { 
	
//	public boolean checkUserValidation(String user,String pass);
	public boolean checkUserValidation(UserInfo u);

}
