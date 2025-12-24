package com.ritik.daoimpl;

import org.springframework.stereotype.Component;

import com.ritik.dao.UserInfoDao;
import com.ritik.pojo.UserInfo;

@Component
public class UserInfoDaoImpl implements UserInfoDao {


	@Override
	public boolean checkUserValidation(UserInfo u) {
		if(u.getUsername().equals("abc@gmail.com") && u.getPassword().equals("abc@123")) 
		return true;
		else	
		return false;
	}
   
	 
}
