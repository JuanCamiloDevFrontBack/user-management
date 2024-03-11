package com.autodidact.usermanagement.module.login.service;

import java.util.stream.Stream;

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

		var infoUser = listUsers.get(0);
		System.out.println("Users DB: " + infoUser.getEmail());
		System.out.println("Users DB: " + infoUser.getEmail().equals(user.user()));
		System.out.println("Users DB: " + infoUser.getPassword().equals(user.password()));
		var isUserValid = infoUser.getEmail().equals(user.user())
				&&
				infoUser.getPassword().equals(user.password());

		if (isUserValid) {
			var hasAcces = true;
			return new LoginDTORes("eabc.yt-dfjklfj48sadfs.sadiojhhr", hasAcces);
		} else {
			throw new CustomException("Error al realizar Login");
		}
	}

	public LoginDTORes accesValid(LoginDTOReq user) {
		
		isRequestUserValid(user);
		
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
	
	private void isRequestUserValid(LoginDTOReq isUserValid) {
				
		var fieldsClass = isUserValid.getClass().getDeclaredFields();
		
		Stream.of(fieldsClass).forEach(field -> {
			var fieldUser = isUserValid.user().equals("")
			||
			isUserValid.user().equals(null);
			
			var fieldPass = isUserValid.password().equals("")
					||
					isUserValid.password().equals(null);
			
			if (fieldUser) {
				System.out.println("campo error" + field.getName());
				throw new CustomException("Error en la solicitud con el campo")
				.msgCustomRequestEmpty(field.getName());
				/*
				 * TODO: segunda forma de utilizar excepciones
				 * personalizadas de manera centralizada.
				 * throw new CustomRequestEmpty("Error en la solicitud con el campo", field.getName());
				 * */
			}
			
			if (fieldPass) {
				System.out.println("campo error" + field.getName());
				throw new CustomException("Error en la solicitud con el campo")
				.msgCustomRequestEmpty(field.getName());
				/*
				 * TODO: segunda forma de utilizar excepciones
				 * personalizadas de manera centralizada.
				 * throw new CustomRequestEmpty("Error en la solicitud con el campo", field.getName());
				 * */
			}
		});
		
	}
	
	private Boolean compareToUser(LoginDAOEntity userDB, LoginDTOReq isUserValid) {
		// TODO: Forma 1
		return isUserValid.equals(userDB);
		
		/*
		 * TODO: Forma 2
		 * return userDB.getEmail()
				.equals(isUserValid.get().user())
				&&
				userDB.getPassword()
				.equals(isUserValid.get().password());*/
	}

}
