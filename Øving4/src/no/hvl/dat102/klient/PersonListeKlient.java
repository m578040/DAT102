package no.hvl.dat102.klient;
import java.util.Scanner;
import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;

public class PersonListeKlient {
	public static void main(String[] args) {
		Scanner leser = new Scanner(System.in);
		OrdnetListeADT<Person> liste = new KjedetOrdnetListe<Person>();
		int ant = 0;
		
		while (ant != 4) {
			System.out.println("Skriv fornavn:");
			String fornavn = leser.nextLine();
			System.out.println("Skriv etternavn:");
			String etternavn = leser.nextLine();
			System.out.println("Skriv fødselsår:");
			int aar = leser.nextInt();
			leser.nextLine();
			
			Person p = new Person(fornavn, etternavn, aar);
			liste.leggTil(p);
			ant++;
		}
		leser.close();
		
		for (int i = 0; i < ant; i++) {
			Person ut = liste.fjernFoerste();
			System.out.println(ut.toString());
		}
	}
}