package com.lin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lin.model.User;
import com.lin.service.LoginService;

@Controller
public class LoginController {

	@Autowired(required=true)
	@Qualifier("loginService")
	private LoginService loginService;
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public void dispaly(){
		System.out.println("---------------INSIDE MAVEN WORKS");
		List<User> userList = this.loginService.getUserList();
		System.out.println("-------userList---CONTROLLER--"+userList.size());
	}
}
