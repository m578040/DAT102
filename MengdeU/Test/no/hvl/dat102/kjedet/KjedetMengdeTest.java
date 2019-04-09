package no.hvl.dat102.kjedet;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class KjedetMengdeTest {
	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;
	private MengdeADT<Integer> fasitMengde;
	
	//Test data
	 private Integer e0 = 1;
	 private Integer e1 = 2;
	 private Integer e2 = 3;
	 private Integer e3 = 4;
	 private Integer e4 = 5;
	 private Integer e5 = 6;
	
	@Before
    public final void setup() throws Exception {
        m1 = new KjedetMengde<Integer>();
        m2 = new KjedetMengde<Integer>();
        fasitMengde = new KjedetMengde<Integer>();
    }
	
	@Test
	public final void unionMedFelles() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		
		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		
		fasitMengde.leggTil(e0);
		fasitMengde.leggTil(e1);
		fasitMengde.leggTil(e2);
		fasitMengde.leggTil(e3);
		fasitMengde.leggTil(e4);
        
		MengdeADT<Integer> begge = m1.union(m2);

        assertTrue(fasitMengde.equals(begge));
    }
	
	@Test
	public final void unionMedDisjunkte() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		
		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);
		
		fasitMengde.leggTil(e0);
		fasitMengde.leggTil(e1);
		fasitMengde.leggTil(e2);
		fasitMengde.leggTil(e3);
		fasitMengde.leggTil(e4);
		fasitMengde.leggTil(e5);
        
		MengdeADT<Integer> begge = m1.union(m2);

        assertTrue(fasitMengde.equals(begge));
    }
	
	@Test
	public final void snittMedFelles() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		
		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		
		fasitMengde.leggTil(e0);
		fasitMengde.leggTil(e1);
		fasitMengde.leggTil(e2);
		fasitMengde.leggTil(e3);
		fasitMengde.leggTil(e4);
		
		MengdeADT<Integer> begge = m1.snitt(m2);

        assertTrue(fasitMengde.equals(begge));
	}
	
	@Test
	public final void snittMedDisjunkte() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		
		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);
		
		MengdeADT<Integer> snittM = m1.snitt(m2);

        assertTrue(snittM.erTom());
	}
	
	@Test
	public final void differensMedFelles() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		m1.leggTil(e3);
		m1.leggTil(e4);
		
		m2.leggTil(e0);
		m2.leggTil(e1);
		m2.leggTil(e2);
		m2.leggTil(e3);
		m2.leggTil(e4);
		
		MengdeADT<Integer> differensM = m1.differens(m2);
		
		assertTrue(differensM.erTom());
	}
	
	@Test
	public final void differensMedDisjunkte() {
		m1.leggTil(e0);
		m1.leggTil(e1);
		m1.leggTil(e2);
		
		m2.leggTil(e3);
		m2.leggTil(e4);
		m2.leggTil(e5);
		
		fasitMengde.leggTil(e0);
		fasitMengde.leggTil(e1);
		fasitMengde.leggTil(e2);
		
		MengdeADT<Integer> differensM = m1.differens(m2);

        assertTrue(fasitMengde.equals(differensM));
	}
}