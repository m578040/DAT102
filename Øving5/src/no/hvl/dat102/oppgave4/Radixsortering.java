package no.hvl.dat102.oppgave4;

import java.util.Random;

public class Radixsortering {

	public static void main(String[] args) {
		// Til bruk ved sortering av store tabellar
		Random tilfeldig = new Random();
		int n = 128000;
		int antal = 10;
		Integer[][] a = new Integer[antal][n];
		// set inn tilfeldige heiltal i alle rekker
		for (int i = 0; i < antal; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = 1000 + tilfeldig.nextInt(9000);
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
		String temp;
		Integer tallObj;
		int siffer, tall;
		TabellKoe<Integer>[] sifferKoe = (TabellKoe<Integer>[])(new TabellKoe[10]);
		
		for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
			sifferKoe[sifferVerdi] = new TabellKoe<Integer>();
		}
		
		for (int pos = 0; pos < 4; pos++) {
			for (int i = 0; i < data.length; i++) {
				temp = String.valueOf(data[i]);
				siffer = Character.digit(temp.charAt(3 - pos), 10);
				sifferKoe[siffer].innKoe(new Integer(data[i]));
			}
			
			tall = 0;
			for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
				while (!(sifferKoe[sifferVerdi].erTom())) {
					tallObj = sifferKoe[sifferVerdi].utKoe();
					data[tall] = tallObj.intValue();
					tall++;
				}
			}
		}
	}
}