package no.hvl.dat102.oppgave4;

import java.util.Random;

public class Flettesortering {

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
		flettesorter(data, 0, data.length - 1);
	}

	private static void flettesorter(Integer[] data, int min, int maks) {
		if (min < maks) {
			int midten = (min + maks) / 2;
			flettesorter(data, min, midten);
			flettesorter(data, midten + 1, maks);
			flett(data, min, midten, maks);
		}
	}

	private static void flett(Integer[] data, int start, int midten, int slutt) {
		Integer[] temp = new Integer[data.length];

		int start1 = start, slutt1 = midten;
		int start2 = midten + 1, slutt2 = slutt;
		int indeks = start1;

		while (start1 <= slutt1 && start2 <= slutt2) {
			if (data[start1].compareTo(data[start2]) < 0) {
				temp[indeks] = data[start1];
				start1++;
			} else {
				temp[indeks] = data[start2];
				start2++;
			}
			indeks++;
		}

		while (start1 <= slutt1) {
			temp[indeks] = data[start1];
			start1++;
			indeks++;
		}

		while (start2 <= slutt2) {
			temp[indeks] = data[start2];
			start2++;
			indeks++;
		}

		for (indeks = start; indeks <= slutt; indeks++) {
			data[indeks] = temp[indeks];
		}
	}
}