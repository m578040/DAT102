package no.hvl.dat102;

import static javax.swing.JOptionPane.*;

public class Butikk {
	private String navn;
	private Vare[] vare;
	private int[] lager;
	private int antalltyper;

	public Butikk(String navn, int maksVarer) {
		this.navn = navn;
		vare = new Vare[maksVarer];
		lager = new int[maksVarer];
		antalltyper = 0;
	}

	public int finnVare(int varenr) {
		boolean funnet = false;
		int i = 0;

		while (!funnet && i < antalltyper) {
			if (vare[i].getVarenummer() == varenr) {
				funnet = true;
			} else {
				i++;
			}
		}

		if (!funnet) {
			return -1;
		} else {
			return i;
		}
	}

	public boolean erLedigPlass() {
		return antalltyper < vare.length;
	}

	public void leggInnNyVare(int varenr) {
		if (finnVare(varenr) >= 0) {
			showMessageDialog(null, "Varen finnes fra før.");
		} else if (!erLedigPlass()) {
			showMessageDialog(null, "Lageret er fullt.");
		} else {
			vare[antalltyper] = new Vare(varenr);
			antalltyper++;
		}
	}

	public void slettVare(int varenr) {
		if (finnVare(varenr) == -1) {
			showMessageDialog(null, "Varen finnes ikke.");
		} else {
			vare[finnVare(varenr)] = vare[antalltyper - 1];
			lager[finnVare(varenr)] = lager[antalltyper - 1];
			vare[antalltyper - 1] = null;
			lager[antalltyper - 1] = 0;

			antalltyper--;
		}
	}

	public void detaljSalg(int varenr) {
		if (finnVare(varenr) == -1) {
			showMessageDialog(null, "Varen finnes ikke.");
		} else if (lager[finnVare(varenr)] == 0) {
			showMessageDialog(null, "Det er 0 stykker igjen på lager");
		} else {
			lager[finnVare(varenr)]--;
		}
	}

	public void grossInnkjøp(int varenr, int tall) {
		if (finnVare(varenr) == -1) {
			showMessageDialog(null, "Varen finnes ikke.");
		} else if (tall < 1) {
			showMessageDialog(null, "Tallet varen skal legges til med er negativt.");
		} else {
			lager[finnVare(varenr)] = lager[finnVare(varenr)] + tall;
		}
	}

	public double salgsVerdi() {
		double sum = 0.0;

		for (int i = 0; i < antalltyper; i++) {
			sum += vare[i].getPris() * lager[i];
		}

		return sum;
	}

	public void lesPris(int varenr) {
		if (finnVare(varenr) == -1) {
			showMessageDialog(null, "Varen finnes ikke.");
		} else {
			vare[finnVare(varenr)].lesVare(varenr);
		}
	}

	public String toString() {
		String str = "Butikk: " + navn + ":" + "\n";

		for (int i = 0; i < antalltyper; i++) {
			str += "Varenr: " + vare[i].getVarenummer() + " Vare: " + vare[i].getNavn() + " Pris: " + vare[i].getPris()
					+ " Antall: " + lager[i] + "\n";
		}

		return str;
	}
}