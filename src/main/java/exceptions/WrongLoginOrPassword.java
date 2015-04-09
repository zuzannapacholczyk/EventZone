package exceptions;


public class WrongLoginOrPassword extends Exception {
	public WrongLoginOrPassword(final String msg) {
		super(msg);
	}
}
