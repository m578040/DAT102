package no.hvl.dat102.datakontaktfirma;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Klient {
	public static void main(String[] args) {
		Hobby h1 = new Hobby("Fotball");
		Hobby h2 = new Hobby("Playstation");
		Hobby h3 = new Hobby("Serier");
		
		KjedetMengde<Hobby> m1 = new KjedetMengde<Hobby>();
		m1.leggTil(h1);
		m1.leggTil(h2);
		
		KjedetMengde<Hobby> m2 = new KjedetMengde<Hobby>();
		m2.leggTil(h1);
		m2.leggTil(h3);
		
		Medlem p1 = new Medlem("Morten Tordal", m1);
		Medlem p2 = new Medlem("Christian Nor", m2);
		
		p1.skrivUt();
		p2.skrivUt();
	}
}