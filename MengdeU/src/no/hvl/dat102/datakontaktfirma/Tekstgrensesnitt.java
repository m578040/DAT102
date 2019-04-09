package no.hvl.dat102.datakontaktfirma;
import no.hvl.dat102.mengde.kjedet.*;;

public class Tekstgrensesnitt {
	
	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem() {
		System.out.println("Oppgi navn på medlem:");
		String navn = Meny.leser.nextLine();
		System.out.println("Oppgi hobbyer, skriv <end> for å avslutte");
		KjedetMengde<Hobby> kjedet = new KjedetMengde<Hobby>();
		String streng = Meny.leser.nextLine();
		while (!(streng.equals("end"))) {
			Hobby h = new Hobby(streng);
			kjedet.leggTil(h);
			streng = Meny.leser.nextLine();
		}
		return new Medlem(navn, kjedet);
	}
	
	// skriver ut hobbylisten for et medlem
	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene til " + medlem.getNavn() + ":");
		System.out.println(medlem.getHobbyer().toString());
	}

	public static void skrivParListe (Datakontakt arkiv) {
		int antPar = 0;
		System.out.println("PARNAVN" + "\t" + "\t" + "\t" + "HOBBYER");
		System.out.println();
		
		for (int i = 0; i < arkiv.antall(); i++) {
			int par = arkiv.getDatakontakt()[i].getStatusIndeks();
			
			if (par != -1 && par > i) {
				antPar++;
				System.out.print(arkiv.getDatakontakt()[i].getNavn() + " og " + arkiv.getDatakontakt()[par].getNavn());
				System.out.println(String.format("%18s", arkiv.getDatakontakt()[i].getHobbyer().toString()));
			}
		}
		
		System.out.println();
		System.out.println("Antall par funnet: " + antPar);
	}
	
	//hjelpemetode
	public static void skrivUtMeny() {
		System.out.println("---------Datakontaktfirma---------");
		System.out.println("1: Legg til et medlem i arkivet.");
		System.out.println("2: Skriv ut liste over hobbyene for et medlem.");
		System.out.println("3: Finn partner for et medlem.");
		System.out.println("4: Skriv ut liste over alle par.");
		System.out.println("5: Tilbakestill status for et medlem.");
		System.out.println("6: Finn union av hobbyene til to medlemmer.");
		System.out.println("7: Finn differens av hobbyene til to medlemmer.");
		System.out.println("8: Finn snitt av hobbyene til to medlemmer.");
		System.out.println("9: Finn ut om hobbyene til et medlem en undermengde av et annet medlems hobbyer?");
		System.out.println("0 for å avslutte.");
	}
}