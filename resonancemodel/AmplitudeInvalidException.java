package resonancemodel;


/**
 * A specific exception class for an invalid Amplitude.
 */
class AmplitudeInvalidException extends Exception {
	/**
	 * Constructor
	 */
	public AmplitudeInvalidException() {}

	/**
	 * Constructor
	 * @param message the exeption message
	 */
	public AmplitudeInvalidException(String message) {
		super(message);
	}
}
