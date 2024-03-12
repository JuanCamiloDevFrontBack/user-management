package com.autodidact.usermanagement.module.login.service;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autodidact.usermanagement.exception.CustomException;
import com.autodidact.usermanagement.module.login.dao.ILoginDAO;
import com.autodidact.usermanagement.module.login.dto.Dto;
import com.autodidact.usermanagement.module.login.entity.LoginDAOEntity;

@Service
public class LoginService {

	@Autowired
	private ILoginDAO loginDao;

	public Dto.LoginRes accesValidTest(Dto.LoginReq user) {

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
		var isUserValid = infoUser.getEmail().equals(user.user()) && infoUser.getPassword().equals(user.password());

		if (isUserValid) {
			var hasAcces = true;
			return Dto.loginRes("eabc.yt-dfjklfj48sadfs.sadiojhhr", hasAcces);
		} else {
			throw CustomException.msgNotFound("Usuario y/o Contraseña incorrectos.");
		}
	}

	/*
	 *  TODO: mencionar que el método ( isRequestUserValid() ) se utiliza a modo de
	 *  ejemplo práctico, sin embargo para este tipo de casos se recomienda utilizar
	 *  la anotación @valid por su facilidad de implementación y reducción de código.
	*/
	public void isRequestUserValid(Dto.LoginReq isUserValid) {

		var msgError = "Error con los campo(s) referentes a la información solicitada.";
		var fieldsLoginReq = isUserValid.getClass().getDeclaredFields();

		Stream.of(fieldsLoginReq).forEach(field -> {
			var fieldUser = isUserValid.user().equals("") || isUserValid.user().equals(null);
			if (fieldUser) {
				//throw CustomException.msgRequestEmpty(msgError, field.getName());
				/*
				 * TODO: segunda forma de utilizar excepciones personalizadas de manera
				 * centralizada. throw new RequestEmpty(msgError, field.getName());
				 */
			}

			var fieldPass = isUserValid.password().equals("") || isUserValid.password().equals(null);
			if (fieldPass && field.getName() == "password") {
				//throw CustomException.msgRequestEmpty(msgError, field.getName());
			}
		});

		// ----------------------------------------------------------------------------------------------
		// TODO: Forma 2
		var isFieldInvalid = false;
		
		for (Field att : fieldsLoginReq) {
			isFieldInvalid = isUserValid.user().equals("") || isUserValid.user().equals(null);
			if (isFieldInvalid) {
				System.out.println("Excepción arrojada.");
				throw CustomException.msgRequestEmpty(msgError, att.getName());
				/*
				 * TODO: segunda forma de utilizar excepciones personalizadas de manera
				 * centralizada. throw new RequestEmpty(msgError, field.getName());
				 */
			}
			
			if (att.getName() == "user") { continue; }

			isFieldInvalid = isUserValid.password().equals("") || isUserValid.password().equals(null);
			if (isFieldInvalid) {
				System.out.println("Excepción arrojada.");
				throw CustomException.msgRequestEmpty(msgError, att.getName());
			}
		}

	}

	public Dto.LoginRes accesValid(Dto.LoginReq user) {

		var listUsers = this.loginDao.findAll();
		var isLogged = false;
		System.out.println("Users DB: " + listUsers);

		for (var isUser : listUsers) {
			System.out.println("User: " + isUser);
			isLogged = this.compareToUser(isUser, user);
			if (isLogged) {
				break;
			}
		}

		if (isLogged) {
			return Dto.loginRes("eabc.yt-dfjklfj48sadfs.sadiojhhr", isLogged);
		} else {
			throw CustomException.msgNotFound("Usuario y/o Contraseña incorrectos.");
		}

	}

	private Boolean compareToUser(LoginDAOEntity userDB, Dto.LoginReq isUserValid) {
		return userDB.getEmail().equals(isUserValid.user()) &&
				 userDB.getPassword().equals(isUserValid.password());
	}

}
