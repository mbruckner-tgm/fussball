package betting.main.exception;

public class PasswordMissmatchException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String exceptionMessage;

	public PasswordMissmatchException() {
		super();
		this.exceptionMessage = "Die eingegebenen Passwörter stimmen nicht überein!";
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	@Override
	public String toString() {
		return "PasswordMissmatchException [exceptionMessage=" + exceptionMessage + "]";
	}

}
