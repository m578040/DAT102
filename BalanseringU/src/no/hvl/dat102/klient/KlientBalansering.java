package no.hvl.dat102.klient;

import no.hvl.dat102.Balansering;
import java.util.*;

public class KlientBalansering {
	public static void main(String[] args) {
		Scanner leser = new Scanner(System.in);
		System.out.println("Gi filnavn:");
		String filnavn = leser.nextLine() + ".txt";
		// Leser inn en tekst fra fil
		leser.close();
		Balansering balansering = new Balansering();
		balansering.lesFraFil(filnavn);
	}// main

}// class
