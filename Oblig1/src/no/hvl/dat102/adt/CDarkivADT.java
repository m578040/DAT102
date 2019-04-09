package no.hvl.dat102.adt;

import no.hvl.dat102.CD;
import no.hvl.dat102.Sjanger;

public interface CDarkivADT {
	// Interface som definerer alle operasjoner i en CDarkivADT
	
		/*
		 * Henter CD-arkivet
		 * 
		 * @return tabell av CD-er
		 */
		CD[] hentCdTabell();
		
		/*
		 * Legger til en CD i CD-arkivet hvis den ikke finnes fra før
		 * Hvis tabellen er full, utvides tabellen med 10%
		 * 
		 * @param nyCd er CD-en som legges til i arkivet
		 */
		void leggTilCd(CD nyCd);
		
		/*
		 * @param cdNr er nummeret som sjekkes opp med alle CD-ene i arkivet.
		 * Hvis cdNr stemmer med et CD-nummer i arkivet, slettes CD-en fra arkivet.
		 * 
		 * @return true hvis sletting var vellykket, false ellers
		 */
		boolean slettCd(int cdNr);
		
		/*
		 * @param delstreng er stringen som sjekkes om den er med i tittelen
		 * 
		 * @return en tabell av CD-er med delstreng i tittelen.
		 */
		CD[] sokTittel(String delstreng);
		
		/*
		 * @param delstreng er stringen som sjekkes om det er navnet på artisten.
		 * 
		 * @return en tabell av CD-er med delstreng i artistnavnet.
		 */
		CD[] sokArtist(String delstreng);
		
		/*
		 * @param sjanger er sjangeren som skal sjekkes antall av.
		 * 
		 * @return antall CD-er av sjangeren
		 */
		int antallSjanger(Sjanger sjanger);
		
		/*
		 * @return antall CD-er i arkivet.
		 */
		int antall();
}