package no.hvl.dat102;

import no.hvl.dat102.tabell.*;

public class RadixSortering {
	public static void main(String[] agrs) {
		int[] liste = { 7843, 4568, 8765, 6543, 7865, 4532, 9987, 3241, 6589, 6622, 1211 , 5543};
		String temp;
		Integer tallObj;
		int siffer, tall;
		TabellKoe<Integer>[] sifferKoe = (TabellKoe<Integer>[]) (new TabellKoe[10]);

		for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
			sifferKoe[sifferVerdi] = new TabellKoe<Integer>();
		}

		/** sorterer liste */
		for (int posisjon = 0; posisjon < 4; posisjon++) {// ytre løkke
			for (int i = 0; i < liste.length; i++) {// indre løkke
				temp = String.valueOf(liste[i]);
				siffer = Character.digit(temp.charAt(3 - posisjon), 10);
				sifferKoe[siffer].innKoe(liste[i]);
			} // indre løkke
			/* legger sorterte tall ut i liste */
			tall = 0;
			for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
				while (!(sifferKoe[sifferVerdi].erTom())) {
					tallObj = sifferKoe[sifferVerdi].utKoe();
					liste[tall] = tallObj.intValue();
					tall++;
				} // while
			} // for
		} // ytre løkke
		
		/** skriver ut sortert listet */
		for (int i=0; i < liste.length; i++){
		System.out.println (liste[i]);
		}
	}
}