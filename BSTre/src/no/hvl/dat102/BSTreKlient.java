package no.hvl.dat102;

import java.util.*;
import no.hvl.dat102.Hjelpemetoder;

public class BSTreKlient {
	final static int ANTALL_NODER = 1024;

	public static void main(String[] args) {
		int hoyeste = 0, laveste = 100, sumHoyde = 0;
		int minHoyde = Hjelpemetoder.finnMinHoyde(ANTALL_NODER);
		int maksHoyde = Hjelpemetoder.finnMaksHoyde(ANTALL_NODER);
		Random tilfeldig = new Random();
		
		for (int i = 0; i < 100; i++) {
			KjedetBSTre<Integer> tre = new KjedetBSTre<Integer>();
			
			for (int j = 0; j < ANTALL_NODER; j++) {
				tre.leggTil(tilfeldig.nextInt(32));
			}
			
			if (hoyeste < tre.finnHoyde()) {
				hoyeste = tre.finnHoyde();
			}
			
			if (laveste > tre.finnHoyde()) {
				laveste = tre.finnHoyde();
			}
			sumHoyde += tre.finnHoyde();
		}
		
		double snitt = sumHoyde/100.0;

		System.out.println("Antall noder: " + ANTALL_NODER);
		System.out.println("Den minimale teoretiske høyden: " + minHoyde);
		System.out.println("Den maksimale teoretiske høyde: " + maksHoyde);
		System.out.println("Høyden til det laveste treet: " + laveste);
		System.out.println("Høyden til det høyeste treet: " + hoyeste);
		System.out.println("Gjennomsnittshøyden til trærne: " + snitt);
	}
}