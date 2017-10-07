package resonancemodel;

/**
 * An interface to resonance models
 */
public interface ResonanceModel {
	/**
	 * * Evaluate the model at a given frequency
	 * * @param frequency the frequency f
	 * * @param parameters the parameters defining the specific model
	 * * @return spectral power P
	 * */
	public double evaluateSpectralPowerAt (
			double frequency , HarmonicOscillatorParameters parameters
			);
}
