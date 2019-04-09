package no.hvl.dat102;

import no.hvl.dat102.adt.*;

public class CDarkiv2 implements CDarkivADT {
	private int antall;
	private LinearNode<CD> start;

	public CDarkiv2() {
		start = null;
		antall = 0;
	}

	@Override
	public CD[] hentCdTabell() {
		LinearNode<CD> denne = start;
		CD[] tab = new CD[antall];

		for (int i = 0; i < antall; i++) {
			tab[i] = denne.getElement();
			denne = denne.getNeste();
		}

		return tab;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> nyNode = new LinearNode<CD>(nyCd);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean slettet = false;
		LinearNode<CD> forrige = null;
		LinearNode<CD> p = start;

		if ((p != null) && (p.getElement().getCDnr() == cdNr)) {
			start = p.getNeste();
			antall--;
			slettet = true;
		} else if (p != null) {
			while (p != null && p.getElement().getCDnr() != cdNr) {
				forrige = p;
				p = p.getNeste();
			}

			forrige.setNeste(p.getNeste());
			antall--;
			slettet = true;
		}

		return slettet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		LinearNode<CD> denne = start;
		CD[] cdTab = new CD[antall];

		int i = 0;
		for (int j = 0; j < antall; j++) {
			if (denne.getElement().getTittel().toLowerCase().contains(delstreng)) {
				cdTab[i] = denne.getElement();
				i++;
			}
			denne = denne.getNeste();
		}
		
		return trimTab(cdTab, i);
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		LinearNode<CD> denne = start;
		CD[] cdTab = new CD[antall];

		int i = 0;
		for (int j = 0; j < antall; j++) {
			if (denne.getElement().getArtist().toLowerCase().contains(delstreng)) {
				cdTab[i] = denne.getElement();
				i++;
			}
			denne = denne.getNeste();
		}
		
		return trimTab(cdTab, i);
	}

	@Override
	public int antallSjanger(Sjanger sjanger) {
		int ant = 0;
		LinearNode<CD> denne = start;

		for (int i = 0; i < antall; i++) {
			if (denne.getElement().getSjanger().equals(sjanger)) {
				ant++;
			}
			denne = denne.getNeste();
		}
		return ant;
	}

	@Override
	public int antall() {
		return antall;
	}

	// hjelpemetode
	private CD[] trimTab(CD[] tab, int n) {
		CD[] cdtab2 = new CD[n];
		int i = 0;
		while (i < n) {
			cdtab2[i] = tab[i];
			i++;
		}
		return cdtab2;
	}
}