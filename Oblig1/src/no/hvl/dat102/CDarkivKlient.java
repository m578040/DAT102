package no.hvl.dat102;
import no.hvl.dat102.adt.*;

public class CDarkivKlient {
	public static void main(String[] args) {
		CDarkivADT cda = new CDarkiv();
		
		// Fjern kommentar for cdarkiv 2
		// CDarkivADT cda = new CDarkiv2();
		
		Meny meny = new Meny(cda);
		
		meny.start();
	}
}