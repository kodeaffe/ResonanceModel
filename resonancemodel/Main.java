package resonancemodel;


import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


/**
 * The main entry point of the application
 * Does some simple command-line handling
 */
class Main {
	/**
	 * The entry point
	 * @param String[] command-line args
	 */
	public static void main(String[] args)
		throws FileNotFoundException, UnsupportedEncodingException {
		if (args.length < 4) {
			System.err.println("Usage: Main <amplitude> <omega0> <qfactor> <filename>");
			System.exit(1);
		}

		// TODO: Proper error handling
		// Currently crashes with NumberFormatException if e.g. strings are
		// given
		double amplitude = Double.parseDouble(args[0]);
		double omega0 = Double.parseDouble(args[1]);
		double qFactor = Double.parseDouble(args[2]);
		String filename = args[3];

		try {
			HarmonicOscillatorParameters parameters =
				new HarmonicOscillatorParameters(
					amplitude, omega0, qFactor);
			HarmonicOscillator oscillator =
				new HarmonicOscillator(parameters);
			FrequencyConfig frequencyConfig = new FrequencyConfig();
			// TODO: Something more useful than rethrowing exceptions
			try {
				oscillator.writeToFile(filename, frequencyConfig);
			} catch (FileNotFoundException|UnsupportedEncodingException e) {
				throw e;
			}
		} catch (
			AmplitudeInvalidException|Omega0InvalidException|QFactorInvalidException e) {
				System.err.println(e);
		}
	}
}
