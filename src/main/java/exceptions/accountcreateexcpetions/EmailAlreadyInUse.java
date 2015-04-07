package exceptions.accountcreateexcpetions;

import exceptions.CreateAccountException;

public class EmailAlreadyInUse extends CreateAccountException {

	public EmailAlreadyInUse(final String msg) {
		super(msg);
	}
}
