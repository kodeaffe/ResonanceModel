package resonancemodel;


import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.Math;


/**
 * The work horse of the application, implementing a ResonanceModel
 */
public class HarmonicOscillator implements ResonanceModel {
	/**
	 * The file encoding used for the output
	 */
	public final String FILE_ENCODING = "UTF-8";

	/**
	 * The parameters of the harmonic oscillator
	 */
	public HarmonicOscillatorParameters parameters;

	/**
	 * Constructor
	 * @param parameters The parameters of the harmonic oscillator
	 */
	public HarmonicOscillator(HarmonicOscillatorParameters parameters) {
		this.parameters = parameters;
	}

	/**
	 * Implementation of the interface from ResonanceModel,
	 * see there for documentation
	 */
	public double evaluateSpectralPowerAt (
		double frequency, HarmonicOscillatorParameters parameters) {
		double spectralPower = 0.;
		double omega = 2 * Math.PI * frequency;
		// for lack of better terms:
		double numerator = Math.pow(parameters.amplitude, 2);
		double omegaSqr = Math.pow(omega, 2);
		double omega0Sqr = Math.pow(parameters.omega0, 2);
		double denominator = 0.;
		double omegaDiff = Math.pow(omegaSqr - omega0Sqr, 2);
		// qFactor is safe thanks to HarmonicOscillatorParameters()
		double omegaQ = (omega0Sqr * omegaSqr) / parameters.qFactor;
		denominator = omegaDiff + omegaQ;
		if (denominator != 0.) {
			 spectralPower = numerator / denominator;
		}
		return spectralPower;
	}

	/**
	 * Calculate harmonic oscillator and write to file
	 * @param filename filename to write to
	 * @param frequencyConfig frequency config to use for calculations
	 */
	public void writeToFile (
		String filename, FrequencyConfig frequencyConfig)
		throws FileNotFoundException, UnsupportedEncodingException {
		double frequencyCurrent = frequencyConfig.start;
		double spectralPower = 0.;
		
		// PrintWriter implements AutoCloseable
		try(PrintWriter writer = new PrintWriter(filename, FILE_ENCODING)) {
			// TODO: Maybe should not just overwrite the file, but warn the
			// user
			System.out.println(String.format(
				"Overwriting file %s", filename));
			writer.println("# Frequency\tSpectral_Power");
			while (frequencyCurrent <= frequencyConfig.stop) {
				spectralPower = this.evaluateSpectralPowerAt(
					frequencyCurrent, this.parameters);
				String out = String.format(
					"% 8.1f\t%e", frequencyCurrent, spectralPower);
				writer.println(out);
				frequencyCurrent += frequencyConfig.step;
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (UnsupportedEncodingException e) {
			throw e;
		}
	}
}
