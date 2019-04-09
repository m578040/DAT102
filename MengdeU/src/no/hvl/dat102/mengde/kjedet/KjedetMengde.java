package no.hvl.dat102.mengde.kjedet;

//********************************************************************
// Kjedet implementasjon av en mengde. 
//********************************************************************
import java.util.*;

import no.hvl.dat102.mengde.adt.*;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/**
	 * Oppretter en tom mengde.
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (!erTom()) {
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = start.getElement();
				start = start.getNeste();
			} else {
				forgjenger = start;
				for (int nr = 2; nr < valg; nr++) {
					forgjenger = forgjenger.getNeste();
				}
				aktuell = forgjenger.getNeste();
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste());
			}
			antall--;
		} // if
		return resultat;
	}//

	@Override
	public T fjern(T element) {
		boolean funnet = false;
		LinearNode<T> forgjenger = null, aktuell = start;
		T resultat = null;
		/*
		 * Fyll ut
		 * 
		 */

		if (!erTom()) {
			if (element.equals(start.getElement())) {
				resultat = start.getElement();
				start = start.getNeste();
				antall--;
			} else {
				forgjenger = start;
				aktuell = start.getNeste();
				while (aktuell != null && !funnet) {
					if (element.equals(aktuell.getElement())) {
						funnet = true;
					} else {
						forgjenger = aktuell;
						aktuell = aktuell.getNeste();
					}
				}
				if (funnet) {
					resultat = aktuell.getElement();
					forgjenger.setNeste(aktuell.getNeste());
					antall--;
				}
			}
		}

		return resultat;
	}//

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		MengdeADT<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;

		/*
		 * Fyll ut
		 */

		while (aktuell != null) {
			((KjedetMengde<T>) begge).settInn(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}

		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			T element = teller.next();
			if (!begge.inneholder(element)) {
				((KjedetMengde<T>) begge).settInn(element);
			}
		}
		return begge;
	}//

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		MengdeADT<T> snittM = new KjedetMengde<T>();
		T element;
		// Fyll ut...

		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			element = teller.next();
			if (this.inneholder(element)) {
				((KjedetMengde<T>) snittM).settInn(element);
			}
		}
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		MengdeADT<T> differensM = new KjedetMengde<T>();
		T element;
		/*
		 * Fyll ut
		 * 
		 */

		Iterator<T> teller = oppramser();
		while (teller.hasNext()) {
			element = teller.next();
			if (!m2.inneholder(element)) {
				((KjedetMengde<T>) differensM).settInn(element);
			}
		}

		return differensM;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}

	@Override
	public boolean equals(MengdeADT<T> m2) {
		boolean likeMengder = true;
		// Fyll ut
		if (antall() == m2.antall()) {
			Iterator<T> teller = m2.oppramser();
			while (teller.hasNext() && likeMengder) {
				if (!inneholder(teller.next())) {
					likeMengder = false;
				}
			}
		} else {
			likeMengder = false;
		}

		return likeMengder;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public Iterator<T> oppramser() {
		return new KjedetIterator<T>(start);
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		boolean erUnderMengde = true;
		// Fyll ut
		Iterator<T> iter = m2.oppramser();
		while (iter.hasNext() && erUnderMengde) {
			if (!this.inneholder(iter.next())) {
				erUnderMengde = false;
			}
		}
		return erUnderMengde;
	}

	private void settInn(T element) {
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	public String toString() {
		String resultat = "<";
		LinearNode<T> aktuell = start;
		while (aktuell.getNeste() != null) {
			resultat += aktuell.getElement().toString() + ", ";
			aktuell = aktuell.getNeste();
		}
		resultat += aktuell.getElement().toString() + ">";
		return resultat;
	}

}// class
