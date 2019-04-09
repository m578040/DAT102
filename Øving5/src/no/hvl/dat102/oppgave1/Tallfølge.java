package no.hvl.dat102.oppgave1;

public class Tallfølge {

	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			System.out.println("For " + i + ": " + beregn(i));
		}
	}
	
	public static int beregn(int t) {
		int res = 0;
		
		if (t == 0) {
			res = 2;
		} else if(t == 1) {
			res = 5;
		} else {
			res = 5 * beregn(t - 1) - 6 * beregn(t - 2) + 2;
		}
		
		return res;
	}
}