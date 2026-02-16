package interfaces.staticmethodsininterfaces.unitconversiontool;

public interface Conversions {
	static double kmToMiles(double kms) {
		return kms*0.621371;
	}
	
	static double kgToLbs(double kg) {
		return kg*2.20462;
	}
}
