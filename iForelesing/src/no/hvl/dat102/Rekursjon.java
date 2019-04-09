package no.hvl.dat102;

public class Rekursjon {
	
	// Rekursiv metode for å finne antall siffer i ett heltall
	public static int antallSiffer(int t) {
		int res;
		
		if (t < 10) {
			res = 1;
		} else {
			res = antallSiffer(t/10) + 1;
		}
		
		return res;
	}
	
	//Rekursiv metode for å snu en tekststreng "abc" -> "cba"
	public static String snuStreng(String s) {
		if (s.length() == 1) {
			return s;
		}
		String resten = s.substring(1);
		return snuStreng(resten) + s.charAt(0);
	}
	
	//Finne maks i en del av en tabell ved rekursjon
	public static int maks(int[] tab, int fra, int til) {
		if (fra == til) {
			return tab[fra];
		} else {
			int midten = (fra + til) / 2;
			int mVenstre = maks(tab, fra, midten);
			int mHøyre = maks(tab, midten + 1, til);
			if (mVenstre >= mHøyre) {
				return mVenstre;
			} else {
				return mHøyre;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(antallSiffer(54321));
		System.out.println(snuStreng("abc"));
		int[] tab = {1, 15, 8, 30, 75, 2};
		System.out.println(maks(tab, 0, 5));
	}
}