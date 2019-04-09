package no.hvl.dat102.oppgave4;

import java.util.Random;

public class SorteringVedInnsetting {

	public static void main(String[] args) {
		// Til bruk ved sortering av store tabellar
		Random tilfeldig = new Random();
		int n = 128000;
		int antal = 10;
		Integer[][] a = new Integer[antal][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antal; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = tilfeldig.nextInt();
			}
		}
		// sorter kvar rekke
		long startTid = System.nanoTime();
		for (int i = 0; i < antal; i++) {
			sorter(a[i]); // blir ein eindimensjonal tabell
		}
		long sluttTid = System.nanoTime();
		
		double tid = ((double)(sluttTid - startTid) / 10000000);
		System.out.println("Tid brukt: " + tid + "ms");
	}

	public static void sorter(Integer[] data) {
		for (int i = 1; i < data.length; i++) {
			Integer tall = data[i];
			int pos = i;

			while (pos > 0 && data[pos - 1].compareTo(tall) > 0) {
				data[pos] = data[pos - 1];
				pos--;
			}

			data[pos] = tall;
		}
	}
}