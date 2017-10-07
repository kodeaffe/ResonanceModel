package resonancemodel;

/**
 * A specific exception class for an invalid Omega 0.
 */
class Omega0InvalidException extends Exception {
	/**
	 * Constructor
	 */
	public Omega0InvalidException() {}

	/**
	 * Constructor
	 * @param message the exeption message
	 */

	public Omega0InvalidException(String message) {
		super(message);
	}
}
