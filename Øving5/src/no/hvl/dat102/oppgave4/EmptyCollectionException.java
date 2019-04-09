package no.hvl.dat102.oppgave4;

//********************************************************************
//  EmptyCollectionException.java   //
//  Representerer situasjonen n�r samlingen er tom.
//********************************************************************

public class EmptyCollectionException extends RuntimeException{
   	

/******************************************************************
     Setter opp dette unntaket med passende melding.
   ******************************************************************/
   public EmptyCollectionException (String samling){
      super (" Denne " + samling + " er tom.");
   }
}
