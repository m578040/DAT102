package no.hvl.dat102.oppgave4;

import java.util.Random;

public class SorteringVedUtvalg {

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

		double tid = ((double) (sluttTid - startTid) / 10000000);
		System.out.println("Tid brukt: " + tid + "ms");
	}

	public static void sorter(Integer[] data) {
		int min;

		for (int i = 0; i < data.length - 1; i++) {
			min = i;

			for (int sok = i + 1; sok < data.length; sok++) {
				if (data[sok].compareTo(data[min]) < 0) {
					min = sok;
				}
			}

			bytt(data, min, i);
		}
	}

	public static void bytt(Integer[] data, int i1, int i2) {
		Integer temp = data[i1];
		data[i1] = data[i2];
		data[i2] = temp;
	}
}