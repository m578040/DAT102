package no.hvl.dat102.oppgave1;

public class Sum {
	
	public static void main(String[] args) {
		System.out.println("Summen er " + summer(100));
	}

	public static int summer(int t) {
		int res = 0;

		if (t == 1) {
			res = 1;
		} else {
			res = summer(t - 1) + t;
		}

		return res;
	}
}