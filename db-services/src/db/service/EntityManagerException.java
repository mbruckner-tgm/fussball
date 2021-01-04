package db.service;

public class EntityManagerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Exception exception;
	private String exceptionMessage;

	public EntityManagerException(Exception exception, String exceptionMessage) {
		super();
		this.exception = exception;
		this.exceptionMessage = exceptionMessage;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	@Override
	public String toString() {
		return "EntityManagerException [exception=" + exception + ", exceptionMessage=" + exceptionMessage + "]";
	}

}
