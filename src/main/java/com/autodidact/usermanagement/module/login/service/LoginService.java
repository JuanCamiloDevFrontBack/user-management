package com.autodidact.usermanagement.module.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autodidact.usermanagement.exception.CustomException;
import com.autodidact.usermanagement.module.login.dao.ILoginDAO;
import com.autodidact.usermanagement.module.login.dto.LoginDTOReq;
import com.autodidact.usermanagement.module.login.dto.LoginDTORes;
import com.autodidact.usermanagement.module.login.entity.LoginDAOEntity;

@Service
public class LoginService {

	@Autowired
	private ILoginDAO loginDao;

	public LoginDTORes accesValidTest(LoginDTOReq user) {

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
			throw new CustomException("Error al realizar Login");
		}
	}

	public LoginDTORes accesValid(LoginDTOReq user) {
		
		var listUsers = this.loginDao.findAll();
		var isLogged = false;
		System.out.println("Users DB: " + listUsers);

		for (LoginDAOEntity isUser : listUsers) {
			System.out.println("User: " + isUser);
			isLogged = this.compareToUser(isUser, user);			
			if (isLogged) { break; }
		}
		
		if (isLogged) {
			return new LoginDTORes("eabc.yt-dfjklfj48sadfs.sadiojhhr", isLogged);
		} else {
			throw new CustomException("Usuario y/o Contraseña incorrectos.");
		}

	}
	
	private Boolean compareToUser(LoginDAOEntity userDB, LoginDTOReq isUserValid) {
		return userDB.getEmail()
				.equals(isUserValid.user())
				&&
				userDB.getPassword()
				.equals(isUserValid.password());
	}

}
