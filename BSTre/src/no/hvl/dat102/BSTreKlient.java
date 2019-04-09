package no.hvl.dat102;

import java.util.*;

public class BSTreKlient {
	final static int ANTALL_NODER = 16;

	public static void main(String[] args) {
		Random tilfeldig = new Random();
		KjedetBSTre<Integer> tre = new KjedetBSTre<Integer>();
		
		for (int i = 0; i < ANTALL_NODER; i++) {
			tre.leggTil(tilfeldig.nextInt(32));
		}
		
		int minHoyde = tre.finnHoyde();
		int maksHoyde = tre.finnHoyde();
		
		System.out.println("Antall noder: " + ANTALL_NODER);
		System.out.println("Den minimale teoretiske høyden: ");
		System.out.println("Den maksimale teoretiske høyde: ");
		System.out.println("Høyden til det laveste treet: " + minHoyde);
		System.out.println("Høyden til det høyeste treet: " + maksHoyde);
		System.out.println("Gjennomsnittshøyden til trærne: ");
	}
}