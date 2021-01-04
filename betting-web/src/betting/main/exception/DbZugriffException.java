package betting.main.exception;

import db.service.EntityManagerException;

public class DbZugriffException extends EntityManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DbZugriffException(Exception exception, String exceptionMessage) {
		super(exception, exceptionMessage);
	}

}
