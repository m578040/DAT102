package no.hvl.dat102.klient;

public class Person implements Comparable<Person> {
	private String fornavn;
	private String etternavn;
	private int fødselsår;
	
	public Person() {
		fornavn = null;
		etternavn = null;
		fødselsår = 0;
	}
	
	public Person(String fornavn, String etternavn, int fødselsår) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.fødselsår = fødselsår;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public int getFødselsår() {
		return fødselsår;
	}

	public void setFødselsår(int fødselsår) {
		this.fødselsår = fødselsår;
	}
	
	public String toString() {
		return "Navn: " + fornavn + " " + etternavn + " Født: " + fødselsår;
	}

	@Override
	public int compareTo(Person p) {
		int resultat = 0;
		
		if (fødselsår > p.fødselsår) {
			resultat = -1;
		} else if (fødselsår < p.fødselsår) {
			resultat = 1;
		} else {
			if (etternavn.compareTo(p.etternavn) < 0) {
				resultat = -1;
			} else if (etternavn.compareTo(p.etternavn) > 0) {
				resultat = 1;
			} else {
				resultat = fornavn.compareTo(p.fornavn);
			}
		}
		
		return resultat;
	}
}