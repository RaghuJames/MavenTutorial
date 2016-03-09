package com.lin.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lin.dao.LoginDAO;
import com.lin.model.User;

@Repository("loginDAO")
public class LoginDAOimpl implements LoginDAO{

	@Autowired
	private SessionFactory sessionFactory ;

	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		try{
		Query q= sessionFactory.openSession().createQuery("from User");
		
		 userList = q.list();
		System.out.println("userList------>>>    "+userList.size());
		for (User user : userList) {
			//System.out.println("---user --"+user.getUserName()+"--code-"+user.getUserCode());
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;
	}

}
