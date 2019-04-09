package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public class SirkulaerKoe<T> implements KoeADT<T> {
	private static final int STDK = 100;
	private int front, bak, antall;
	private T[] koe;

	public SirkulaerKoe() {
		this(STDK);
	}

	public SirkulaerKoe(int startKapasitet) {
		koe = (T[]) (new Object[startKapasitet]);
		front = bak = 0;
		antall = 0;
	}

	@Override
	public void innKoe(T element) {
		if (antall() == koe.length) {
			utvid();
		}

		koe[bak] = element;
		bak = (bak + 1) % koe.length;
		antall++;
	}

	@Override
	public T utKoe() {
		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}

		T resultat = koe[front];
		koe[front] = null;
		front = (front + 1) % koe.length;
		antall--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}
		
		T resultat = koe[front];
		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall() == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	private void utvid() {
		T[] hjelpetabell = (T[]) (new Object[koe.length * 2]);
		for (int soek = 0; soek < antall; soek++) {
			hjelpetabell[soek] = koe[front];
			front = (front + 1) % koe.length;
		}

		front = 0;
		bak = antall;
		koe = hjelpetabell;
	}

}