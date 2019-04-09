package no.hvl.dat102.oppgave4;

import java.util.Random;

public class NyKvikksortering {
	private static final int MIN = 10;

	public static void main(String[] args) {
		// Til bruk ved sortering av store tabellar
		Random tilfeldig = new Random();
		int n = 150;
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
	
	public static <T extends Comparable<T>> void sorter(T[] data) {
		kvikkSortNy(data, 0, data.length - 1);
	}
	
	public static <T extends Comparable<T>> void kvikkSortNy(T[] data, int min, int maks) {
		kvikkSort2(data, min, maks);
		sorteringVedInnsetting2(data, min, maks);
	}

	public static <T extends Comparable<T>> void kvikkSort2(T[] data, int min, int maks) {
		int posPartisjon;
		if (maks - min + 1 > MIN) {// antall elementer > MIN ?
			/** Lager partisjon */
			posPartisjon = partisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikksorter(data, min, posPartisjon - 1);
			/** Sorterer høyre side */
			kvikksorter(data, posPartisjon + 1, maks);
		}
	}// metode
	
	private static <T extends Comparable<T>> void kvikksorter(T[] data, int min, int maks) {
		if (min < maks) {
			int indeksPartisjon = partisjon(data, min, maks);
			kvikksorter(data, min, indeksPartisjon - 1);
			kvikksorter(data, indeksPartisjon + 1, maks);
		}
	}

	private static <T extends Comparable<T>> int partisjon(T[] data, int min, int maks) {
		T partisjonElement;
		int venstre, hoyre;
		int midten = (min + maks) / 2;

		partisjonElement = data[midten];

		bytt(data, midten, min);
		venstre = min;
		hoyre = maks;

		while (venstre < hoyre) {
			while (venstre < hoyre && data[venstre].compareTo(partisjonElement) <= 0) {
				venstre++;
			}

			while (data[hoyre].compareTo(partisjonElement) > 0) {
				hoyre--;
			}

			if (venstre < hoyre) {
				bytt(data, venstre, hoyre);
			}
		}

		bytt(data, min, hoyre);

		return hoyre;
	}
	
	public static <T extends Comparable<T>> void bytt(T[] data, int i1, int i2) {
		T temp = data[i1];
		data[i1] = data[i2];
		data[i2] = temp;
	}

	public static <T extends Comparable<T>> void sorteringVedInnsetting2(T[] data, int forste, int siste) {
		for (int indeks = forste + 1; indeks <= siste; indeks++) {
			T nokkel = data[indeks];
			int p = indeks;
			// Forskyv større verdier mot høyre
			while (p > 0 && data[p - 1].compareTo(nokkel) > 0) {
				data[p] = data[p - 1];
				p--;
			}
			data[p] = nokkel;
		} // ytre
	}// metode
}