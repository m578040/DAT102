package no.hvl.dat102.datakontaktfirma;

import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {
	private String navn;
	private KjedetMengde<Hobby> hobbyer;
	private int statusIndeks;
	
	public Medlem() {
		navn = null;
		hobbyer = new KjedetMengde<Hobby>();
		statusIndeks = -1;
	}
	
	public Medlem(String navn, KjedetMengde<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		statusIndeks = -1;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public KjedetMengde<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(KjedetMengde<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
	
	public void skrivUt() {
		System.out.println(navn + "\t" + hobbyer.toString() + "\t" + statusIndeks);
	}
	
	public boolean passerTil(Medlem medlem2) {
		return (this.hobbyer.equals(medlem2.hobbyer));
	}
	
	public KjedetMengde<Hobby> unionHobbyer(Medlem m) {
		return (KjedetMengde<Hobby>) this.hobbyer.union(m.hobbyer);
	}
	
	public KjedetMengde<Hobby> differensHobbyer(Medlem m) {
		return (KjedetMengde<Hobby>) this.hobbyer.differens(m.hobbyer);
	}
	
	public KjedetMengde<Hobby> snittHobbyer(Medlem m) {
		return (KjedetMengde<Hobby>) this.hobbyer.snitt(m.hobbyer);
	}
	
	public boolean undermengde(Medlem m) {
		return this.hobbyer.undermengde(m.hobbyer);
	}
}