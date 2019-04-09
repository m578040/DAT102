package no.hvl.dat102.exception;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen n�r samlingen er tom
//********************************************************************
public class WrongCloseSymbolException extends RuntimeException {
	/******************************************************************
	 * Setter opp et unntak med passende melding.
	 ******************************************************************/
	public WrongCloseSymbolException(char symbol, int linjenr, int posisjon) {
		super("Åpnesymbol " + symbol + " på linje nr " + linjenr + ", tegn nr " + posisjon + " har feil lukkesymbol.");
	}
}
