package no.hvl.dat102;

import no.hvl.dat102.adt.*;
import java.util.Scanner;
import static java.lang.Integer.*;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;
	private static final String SKILLE = "-----------------------------------------------------------";
	public static final Scanner in = new Scanner(System.in);

	public Meny(CDarkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}

	public void start() {
		
		boolean gyldig = false;
		String filnavn = "";

		do {
			System.out.println("Ønsker du å jobbe med et eksisterende arkiv? (ja/nei)");

			String svar = in.nextLine();
			System.out.println(SKILLE);

			if (svar.equals("ja")) {
				System.out.println("Gi filnavn:");
				filnavn = in.nextLine();
				System.out.println(SKILLE);

				cda = Fil.lesFraFil(filnavn);
				gyldig = true;
			} else if (svar.equals("nei")) {
				System.out.println("Gi filnavn på det nye arkivet:");
				filnavn = in.nextLine();
				System.out.println(SKILLE);
				
				
				gyldig = true;
			} else {
				System.out.println(svar + " er ikke et gyldig svar.");
			}
		} while (!gyldig);
		
		String meny = "Skriv tallet for operasjonen du ønsker å utføre:" + "\n" +
					"1: Legge til en ny CD i arkivet." + "\n" +
					"2: Slette en ny CD fra arkivet." + "\n" +
					"3: Hente antall CD-er i arkivet." + "\n" +
					"4: Skrive ut info om alle CD-er med en gitt delstreng i tittelen." + "\n" +
					"5: Skrive ut info om alle CD-er av en gitt artist." + "\n" +
					"6: Skrive ut statistikk om CD-arkivet." + "\n" +
					"0: Lagre og avslutt.";
		
		int input = 1;
		
		 while(input != 0) {
			System.out.println(meny);
			
			input = parseInt(in.nextLine());
			
			switch(input) {
			case 1: CD nyCD = tekstgr.lesCD();
					cda.leggTilCd(nyCD);
					break;
			case 2: System.out.println("Gi CD-nummer:");
					 if (cda.slettCd(parseInt(in.nextLine()))) {
						 System.out.println("Sletting vellykket.");
					 } else {
						 System.out.println("Noe gikk galt.");
					 }
					break;
			case 3: System.out.println("Antall CD-er i arkivet: " + cda.antall());
					break;
			case 4: System.out.println("Gi delstreng i tittelen på CD-er:");
					tekstgr.skrivUtCdDelstrengITittel(cda, in.nextLine());
					break;
			case 5: System.out.println("Gi artistnavn:");
					tekstgr.skrivUtCdArtist(cda, in.nextLine());
					break;
			case 6: tekstgr.skrivUtStatistikk(cda);
					break;
			}
			
			System.out.println(SKILLE);
		}
		
		Fil.skrivTilFil(cda, filnavn);
		in.close();
		System.out.println("Programmet er avsluttet.");
	}
}