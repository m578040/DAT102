package no.hvl.dat102.klient;
import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.kjedet.KjedetKoe;
import java.util.*;

public class PersonKoeKlient {
	public static void main(String[] args) {
		Scanner leser = new Scanner(System.in);
		KoeADT<Person> koe = new KjedetKoe<Person>();
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
			koe.innKoe(p);
			ant++;
		}
		leser.close();
		
		for (int i = 0; i < ant; i++) {
			Person ut = koe.utKoe();
			System.out.println(ut.toString());
		}
	}
}