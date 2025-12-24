package com.ritik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ritik.dao.UserInfoDao;
import com.ritik.pojo.UserInfo;

@Controller
public class HomeController {
	
    private UserInfoDao daoimpl;
    
    @Autowired
	public void setDaoimpl(UserInfoDao daoimpl) {
		this.daoimpl = daoimpl;
	}

	@RequestMapping("/")
	public String indpage()
	{
		return "login";
	}


//	@RequestMapping(value = "/checkuser")
//    public String checkUser(UserInfo u, ModelMap m)
//    {
//		if(daoimpl.checkUserValidation(u))
//		{
//			m.addAttribute("username",u.getUsername());
//			m.addAttribute("hello","welcome");
//			return "home";
//		}
//		else
//		{
//			m.addAttribute("msg","invalid Username/password");
//			return "error";
//		}
//    }
	
//	@RequestMapping(value = "/checkuser")
//    public String checkUser(UserInfo u, Model m)
//    {
//		if(daoimpl.checkUserValidation(u))
//		{
//			m.addAttribute("username",u.getUsername());
//			return "home";
//		}
//		else
//		{
//			m.addAttribute("msg","invalid Username/password");
//			return "error";
//		}
//    }
//	
	

	@RequestMapping(value = "/checkuser")
	public ModelAndView checkUser(UserInfo u)
	{
		ModelAndView mv = null;
		if(daoimpl.checkUserValidation(u))
		{
			mv = new ModelAndView("home","username",u.getUsername());
			return mv;
		}
		else
		{
			mv = new ModelAndView("error","msg","Invalid Username/Password");
			return mv;
		}	
	}
}

