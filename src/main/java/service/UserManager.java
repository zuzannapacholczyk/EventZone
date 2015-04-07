package service;

import model.User;
import exceptions.accountcreateexcpetions.EmailAlreadyInUse;
import exceptions.accountcreateexcpetions.LoginAlreadyInUse;

public abstract class UserManager {

	public abstract User getUserByLogin(String login);

	public abstract void saveUser(User user) throws EmailAlreadyInUse, LoginAlreadyInUse;

	public void testService() {
		System.out.println("service works");
	}
}
