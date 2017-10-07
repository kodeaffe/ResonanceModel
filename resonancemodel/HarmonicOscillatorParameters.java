package resonancemodel;


/**
 * Parameters for the HarmonicOscillator
 */
public class HarmonicOscillatorParameters {
	/**
	 * Amplitude of the oscillator
	 */
	public double amplitude;

	/**
	 * Value for Omega 0 of the oscillator
	 */
	public double omega0;

	/**
	 * Q factor of the oscillator
	 */
	public double qFactor;

	/**
	 * Constructor
	 * @param amplitude The amplitude of the oscillator
	 * @param omega0 The value for Omega 0 of the oscillator
	 * @param qFactor Q factor of the oscillator
	 */
	public HarmonicOscillatorParameters(
		double amplitude, double omega0, double qFactor) 
		throws AmplitudeInvalidException, Omega0InvalidException,
			QFactorInvalidException {
		if (amplitude <= 0) {
			throw new AmplitudeInvalidException("Amplitude must be > 0.");
		}
		this.amplitude = amplitude;

		if (omega0 <= 0) {
			throw new Omega0InvalidException("Omega0 must be > 0.");
		}
		this.omega0 = omega0;

		if (qFactor <= 0. || qFactor >= 100.) {
			throw new QFactorInvalidException(
				"Q factor must be 0. < q < 100.");
		}
		this.qFactor = qFactor;
	}
}
