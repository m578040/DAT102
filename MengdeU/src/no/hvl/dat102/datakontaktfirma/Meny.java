package no.hvl.dat102.datakontaktfirma;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

public class Meny {
	public static final Scanner leser = new Scanner(System.in);

	public static void main(String[] args) {
		int input = 1;
		Datakontakt arkiv = new Datakontakt();

		while (input != 0) {
			Tekstgrensesnitt.skrivUtMeny();

			input = parseInt(leser.nextLine());

			switch (input) {
			case 1:
				Medlem m = Tekstgrensesnitt.lesMedlem();
				arkiv.leggTilMedlem(m);
				break;
			case 2:
				System.out.println("Skriv inn navn på medlem:");
				String navn = leser.nextLine();
				int ind = arkiv.finnMedlemsIndeks(navn);
				if (ind == -1) {
					System.out.println("Medlem ikke funnet");
				} else {
					Tekstgrensesnitt.skrivHobbyListe(arkiv.getDatakontakt()[ind]);
				}
				break;
			case 3: 
				System.out.println("Skriv inn navn på medlem:");
				navn = leser.nextLine();
				int res = arkiv.finnPartnerfor(navn);
				if (res == -1) {
					System.out.println("Fant ingen partnere for " + navn + ".");
				} else {
					System.out.println("Partner funnet for " + navn + ".");
				}
				break;
			case 4:
				Tekstgrensesnitt.skrivParListe(arkiv);
				break;
			case 5:
				System.out.println("Skriv inn navn på medlem:");
				navn = leser.nextLine();
				arkiv.tilbakestillStatusIndeks(navn);
				break;
			case 6:
				System.out.println("Skriv navnet på det første medlemmet:");
				String navnM1 = leser.nextLine();
				System.out.println("Skriv navnet på det andre medlemmet:");
				String navnM2 = leser.nextLine();
				int i1 = arkiv.finnMedlemsIndeks(navnM1);
				int i2 = arkiv.finnMedlemsIndeks(navnM2);
				System.out.println("Unionen:");
				System.out.println(arkiv.getDatakontakt()[i1].unionHobbyer(arkiv.getDatakontakt()[i2]).toString());
				break;
			case 7:
				System.out.println("Skriv navnet på det første medlemmet:");
				navnM1 = leser.nextLine();
				System.out.println("Skriv navnet på det andre medlemmet:");
				navnM2 = leser.nextLine();
				i1 = arkiv.finnMedlemsIndeks(navnM1);
				i2 = arkiv.finnMedlemsIndeks(navnM2);
				System.out.println("Differensen:");
				System.out.println(arkiv.getDatakontakt()[i1].differensHobbyer(arkiv.getDatakontakt()[i2]).toString());
				break;
			case 8:
				System.out.println("Skriv navnet på det første medlemmet:");
				navnM1 = leser.nextLine();
				System.out.println("Skriv navnet på det andre medlemmet:");
				navnM2 = leser.nextLine();
				i1 = arkiv.finnMedlemsIndeks(navnM1);
				i2 = arkiv.finnMedlemsIndeks(navnM2);
				System.out.println("Snittet:");
				System.out.println(arkiv.getDatakontakt()[i1].snittHobbyer(arkiv.getDatakontakt()[i2]).toString());
				break;
			case 9:
				System.out.println("Skriv navnet på det første medlemmet:");
				navnM1 = leser.nextLine();
				System.out.println("Skriv navnet på det andre medlemmet:");
				navnM2 = leser.nextLine();
				i1 = arkiv.finnMedlemsIndeks(navnM1);
				i2 = arkiv.finnMedlemsIndeks(navnM2);
				if (arkiv.getDatakontakt()[i1].undermengde(arkiv.getDatakontakt()[i2])) {
					System.out.println("Hobbyene til " + navnM2 + " er en undermengde av" + " hobbyene til " + navnM1);
				} else {
					System.out.println(
							"Hobbyene til " + navnM2 + " er ikke en undermengde av" + " hobbyene til " + navnM1);
				}
				break;
			}
		}

		leser.close();
		System.out.println("Programmet er avsluttet.");
	}
}