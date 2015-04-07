package exceptions.accountcreateexcpetions;

import exceptions.CreateAccountException;

public class LoginAlreadyInUse extends CreateAccountException {
	public LoginAlreadyInUse(final String msg) {
		super(msg);
	}
}
