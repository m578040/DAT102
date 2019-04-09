package no.hvl.dat102;

public class Hjelpemetoder {
	public static int finnMinHoyde(int antallNoder) {
		return (int) (Math.log(antallNoder) / Math.log(2));
	}

	public static int finnMaksHoyde(int antallNoder) {
		return antallNoder - 1;
	}
}