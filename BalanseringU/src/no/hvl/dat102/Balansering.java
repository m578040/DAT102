package no.hvl.dat102;

import java.io.*;
import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.TabellStabel;
import no.hvl.dat102.exception.*;

public class Balansering {
	StabelADT<Parentesinfo> stabel = new TabellStabel<Parentesinfo>();

	private boolean passer(char aapent, char lukket) {
		switch (aapent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}//

	public void foretaBalansering(String innDataStreng, int linjenr) {

		int lengde = innDataStreng.length();
		// Fyll ut
		int i = 0;
		boolean fortsattBalansert = true;

		while (i < lengde && fortsattBalansert) {
			char symbol = innDataStreng.charAt(i);
			if (symbol == '(' || symbol == '[' || symbol == '{') {
				Parentesinfo s = new Parentesinfo(linjenr, i, symbol);
				stabel.push(s);
			} else if (symbol == ')' || symbol == ']' || symbol == '}') {
				if (stabel.erTom()) {
					fortsattBalansert = false;
					throw new MissingOpenSymbolException(symbol, linjenr, i);
				} else {
					Parentesinfo p = stabel.pop();
					if (!passer(p.getVenstreparentes(), symbol)) {
						fortsattBalansert = false;
						throw new WrongOpenSymbolException(symbol, linjenr, i);
					}
				}
			}
			i++;
		}
	}//

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				// kalle metode her!
				// Fyll ut
				foretaBalansering(linje, linjenr);
				linjenr++;
				linje = tekstLeser.readLine();

			} // while
			
			if (!stabel.erTom()) {
				Parentesinfo p = stabel.pop();
				throw new WrongCloseSymbolException(p.getVenstreparentes(), p.getLinjenr(), p.getPosisjon());
			} else {
				System.out.println("Teksten er balansert.");
			}
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}// metode

}// class
