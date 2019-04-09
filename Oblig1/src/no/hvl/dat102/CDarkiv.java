package no.hvl.dat102;

import no.hvl.dat102.adt.*;

public class CDarkiv implements CDarkivADT {
	private CD[] cdTabell;
	private int antall;

	public CDarkiv() {
		cdTabell = new CD[100];
		antall = 0;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		if (finnes(nyCd.getCDnr())) {
			System.out.println("CD-en finnes fra før, den ble ikke lagt til i arkivet.");
		} else {
			if (antall == cdTabell.length) {
				utvid();
			}
			cdTabell[antall] = nyCd;
			antall++;
		}
	}

	@Override
	public CD[] hentCdTabell() {
		return cdTabell;
	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean slettet = false;
		int i = 0;

		while (i < antall && !slettet) {
			if (cdTabell[i].getCDnr() == cdNr) {
				if (antall > 1) {
					cdTabell[i] = cdTabell[antall - 1];
					cdTabell[antall - 1] = null;
					antall--;
					slettet = true;
				} else {
					cdTabell[i] = null;
					antall--;
					slettet = true;
				}
			}
			i++;
		}

		return slettet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] cdTab = new CD[antall];

		int i = 0;
		for (int j = 0; j < antall; j++) {
			if (cdTabell[j].getTittel().toLowerCase().contains(delstreng)) {
				cdTab[j] = cdTabell[j];
				i++;
			}
		}

		return trimTab(cdTab, i);
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] cdTab = new CD[antall];

		int i = 0;
		for (int j = 0; j < antall; j++) {
			if (cdTabell[j].getArtist().toLowerCase().contains(delstreng)) {
				cdTab[j] = cdTabell[j];
				i++;
			}
		}

		return trimTab(cdTab, i);
	}

	@Override
	public int antallSjanger(Sjanger sjanger) {
		int ant = 0;

		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getSjanger() == sjanger) {
				ant++;
			}
		}

		return ant;
	}

	public int antall() {
		return antall;
	}

	// hjelpemetode
	private boolean finnes(int cdnr) {
		boolean funnet = false;
		int i = 0;

		while (!funnet && i < antall) {
			if (cdTabell[i].getCDnr() == cdnr) {
				funnet = true;
			}
			i++;
		}

		return funnet;
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

	// hjelpemetode
	private void utvid() {
		CD[] hjelpetabell = new CD[(int) (cdTabell.length * 1.10)];

		for (int i = 0; i < cdTabell.length; i++) {
			hjelpetabell[i] = cdTabell[i];
		}
		cdTabell = hjelpetabell;
	}
}