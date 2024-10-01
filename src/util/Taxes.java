package util;

public class Taxes {

	public static double ipi(double serviceAmount, double freight, double security) {
		return (serviceAmount + freight + security) * 0.15;
	}
	
	public static double icms(double serviceAmount, double aliquotOrigintoDestiny) {
		return serviceAmount * aliquotOrigintoDestiny;
	}
	
	public static double iss(double taxRateApplied, double serviceAmount) {
		return taxRateApplied * serviceAmount;
	}
}
