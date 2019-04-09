package no.hvl.dat102.exception;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen n�r samlingen er tom
//********************************************************************
public class WrongOpenSymbolException extends RuntimeException {
	/******************************************************************
	 * Setter opp et unntak med passende melding.
	 ******************************************************************/
	public WrongOpenSymbolException(char symbol, int linjenr, int posisjon) {
		super("Lukkesymbol " + symbol + " på linje nr " + linjenr + ", tegn nr " + posisjon + " har feil åpnesymbol.");
	}
}
