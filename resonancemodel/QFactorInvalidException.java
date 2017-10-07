package resonancemodel;

/**
 * A specific exception class for an invalid Q factor.
 */
class QFactorInvalidException extends Exception {
	/**
	 * Constructor
	 */
	public QFactorInvalidException() {}

	/**
	 * Constructor
	 * @param message the exeption message
	 */
	public QFactorInvalidException(String message) {
		super(message);
	}
}
