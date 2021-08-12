package exceptions;

public class NotFullPaidException extends Exception {

	public NotFullPaidException(String errorMessage) {
		super(errorMessage);
	}

}
