package resonancemodel;

/**
 * Configuration of the frequencies used for calculating the output of a
 * harmonic oscillator
 * TODO: Maybe there is a better way to clarify what this does?
 */
public class FrequencyConfig {
	/**
	 * The start frequency
	 */
	public double start = 100.;

	/**
	 * The stop frequency
	 */
	public double stop = 10000.;

	/**
	 * The step between frequencies
	 */
	public double step = 100.;

	/**
	 * Constructor
	 * Using default values above
	 */
	public FrequencyConfig() {}

	/**
	 * Constructor
	 * @param start the start frequency
	 * @param stop the stop frequency
	 * @param step the step value taken in each iteration from start to stop
	 */
	public FrequencyConfig(double start, double stop, double step) {
		this.start = start;
		this.stop = stop;
		this.step = step;
	}
}
