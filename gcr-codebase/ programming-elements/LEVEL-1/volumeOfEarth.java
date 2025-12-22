public class volumeOfEarth{
	public static void main(String [] args){
		double radiusKm = 6378;
		double pi = 3.14159265359;

		double volumeKm = (4/3) * pi * radiusKm * radiusKm * radiusKm;
		double volumeMiles = volumeKm * Math.pow(0.621371, 3);

		System.out.println("The volume of earth in cubic kilometers is " + volumeKm +
            " and cubic miles is " + volumeMiles);
	}
}