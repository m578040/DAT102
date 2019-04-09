package no.hvl.dat102.exception;
//********************************************************************
//  NotBalancedException.java   //
//  Representerer situasjonen når samlingen ikke er balansert
//********************************************************************
public class MissingOpenSymbolException extends RuntimeException{
   /******************************************************************
     Setter opp et unntak med passende melding.
   ******************************************************************/
   public MissingOpenSymbolException (char symbol, int linjenr, int posisjon) {
      super ("Lukkesymbol " + symbol + " på linje " + linjenr + ", tegn nr " + posisjon
				+ " mangler tilsvarende åpnesymbol.");
   }
}