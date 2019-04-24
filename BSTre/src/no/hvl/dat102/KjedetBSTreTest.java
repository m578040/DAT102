package no.hvl.dat102;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class KjedetBSTreTest {

	private KjedetBSTre<Integer> bst;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	private Integer e6 = 7;
	private Integer e7 = 8;

	@Before
	public final void setup() throws Exception {
		bst = new KjedetBSTre<Integer>();
	}

	@Test
	public final void erElementIBSTre() {
		bst.leggTil(e2);
		bst.leggTil(e0);
		bst.leggTil(e5);
		bst.leggTil(e3);
		bst.leggTil(e1);
		bst.leggTil(e6);
		bst.leggTil(e4);

		assertEquals(e0, bst.finn(e0));
		assertEquals(e1, bst.finn(e1));
		assertEquals(e2, bst.finn(e2));
		assertEquals(e3, bst.finn(e3));
		assertEquals(e4, bst.finn(e4));
		assertEquals(e5, bst.finn(e5));
		assertEquals(e6, bst.finn(e6));

		assertEquals(null, bst.finn(e7));
	}

	@Test
	public final void erBSTreOrdnet() {
		/*
		 * Her legge du først inn e0...e6 i en vilkårlig rekkefølge og så fjerne du
		 * minste hele tiden
		 */
		bst.leggTil(e3);
		bst.leggTil(e4);
		bst.leggTil(e5);
		bst.leggTil(e2);
		bst.leggTil(e6);
		bst.leggTil(e1);
		bst.leggTil(e0);

		assertEquals(e0, bst.fjernMin());
		assertEquals(e1, bst.fjernMin());
		assertEquals(e2, bst.fjernMin());
		assertEquals(e3, bst.fjernMin());
		assertEquals(e4, bst.fjernMin());
		assertEquals(e5, bst.fjernMin());
		assertEquals(e6, bst.fjernMin());
	}

	/**
	 * 2 Tester ordning ved å bruke en inordeniterator Her studerer du alt om bruk
	 * av inordeniterator.
	 */
	@Test
	public final void erBSTreOrdnet2() {
		bst.leggTil(e3);
		bst.leggTil(e2);
		bst.leggTil(e4);
		bst.leggTil(e1);
		bst.leggTil(e5);
		bst.leggTil(e0);
		bst.leggTil(e6);

		Integer el[] = { e0, e1, e2, e3, e4, e5, e6 };
		int i = 0;
		for (Integer e : bst) {
			assertEquals(el[i], e);
			i++;
		}

	}
}