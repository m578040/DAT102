package no.hvl.dat102;

import static java.lang.Integer.*;
import no.hvl.dat102.adt.*;

public class Tekstgrensesnitt {
	public CD lesCD() {
		System.out.println("Gi CD-nummer:");
		int nr = parseInt(Meny.in.nextLine());
		System.out.println("Gi navn på artist/band:");
		String navn = Meny.in.nextLine();
		System.out.println("Gi tittel på CD:");
		String tittel = Meny.in.nextLine();
		System.out.println("Gi lanseringsår:");
		int lansering = parseInt(Meny.in.nextLine());
		System.out.println("Gi sjanger (1-5):");
		int sjanger = parseInt(Meny.in.nextLine());

		System.out.println("Gi plateselskap:");
		String plateselskap = Meny.in.nextLine();
		CD nyCd = new CD(nr, navn, tittel, lansering, Sjanger.finnSjanger(sjanger), plateselskap);

		return nyCd;
	}

	public void visCD(CD cd) {
		System.out.println("CD-nummer: " + cd.getCDnr());
		System.out.println("Artist: " + cd.getArtist());
		System.out.println("Tittel: " + cd.getTittel());
		System.out.println("Lanseringsår: " + cd.getLansering());
		System.out.println("Sjanger:" + cd.getSjanger());
		System.out.println("Plateselskap: " + cd.getPlateselskap());
	}

	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {
		if (cda.sokTittel(delstreng) == null) {
			System.out.println("Ingen CD-er funnet.");
		} else {
			for (CD i : cda.sokTittel(delstreng)) {
				visCD(i);
				System.out.println();
			}
		}
	}

	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
		if (cda.sokArtist(delstreng) == null) {
			System.out.println("Ingen artister funnet.");
		} else {
			for (CD i : cda.sokArtist(delstreng)) {
				visCD(i);
				System.out.println();
			}
		}
	}

	public void skrivUtStatistikk(CDarkivADT cda) {
		System.out.println("Antall CD-er i arkivet: " + cda.antall());
		System.out.println();

		for (Sjanger i : Sjanger.values()) {
			System.out.println("Antall CD-er i sjangeren " + i + ": " + cda.antallSjanger(i));
		}
	}
}