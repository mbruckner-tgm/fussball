package betting.main.exception;

public class UserAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String exceptionMessage;

	public UserAlreadyExistsException() {
		super();
		this.exceptionMessage = "Der User existiert bereits!";
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	@Override
	public String toString() {
		return "UserAlreadyExists [exceptionMessage=" + exceptionMessage + "]";
	}
}
