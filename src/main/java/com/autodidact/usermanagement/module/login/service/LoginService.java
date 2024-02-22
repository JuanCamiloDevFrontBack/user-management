package com.autodidact.usermanagement.module.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autodidact.usermanagement.module.login.dao.ILoginDAO;
import com.autodidact.usermanagement.module.login.dto.LoginDTOReq;
import com.autodidact.usermanagement.module.login.dto.LoginDTORes;

@Service
public class LoginService {
	
	@Autowired
	private ILoginDAO loginDao;
	
	public LoginDTORes accesValid(LoginDTOReq user) {
		
		var listUsingWhere = this.loginDao.searchByUserFirst();
		System.out.println("list con where: " + listUsingWhere);
		System.out.println("-----------------");
		
		var listUsingWhereJPQL = this.loginDao.searchByIdQueryJPQL(3);
		System.out.println("list con where JPQL: " + listUsingWhereJPQL);
		System.out.println("-----------------");
		
		var listUsers = this.loginDao.findAll();
		System.out.println("Users DB: " + listUsers);
		
		var x = listUsers.get(0);
		System.out.println("Users DB: " + x.getEmail());
		System.out.println("Users DB: " + x.getEmail().equals(user.user()));
		System.out.println("Users DB: " + x.getPassword().equals(user.password()));
		var y = x.getEmail().equals(user.user()) && x.getPassword().equals(user.password());
		
		if (y) {
			return new LoginDTORes("eabc.yt-dfjklfj48sadfs.sadiojhhr", true);
		} else {
			return new LoginDTORes("", false);
		}
	}

}
