package no.hvl.dat102.adt;

 /* Definerer interface til en datastruktur stabel.
 */
public interface StabelADT<T> {
	/**
	 * Legger p� et element p� toppen av stabelen.
	 */
	public void push(T element);

	/**
	 * Fjerner og returnerer toppelementet fra stabelen.
	 * 
	 * @return elementet som avstables
	 */
	public T pop();

	/**
	 * Returnerer toppelemnetet uten � fjerne det fra stabelen.
	 * 
	 * @return toppelementet
	 */
	public T peek();

	/**
	 * Returnerer sann hvis stabelen ikke inneholder noen elemnter
	 * 
	 * @return sann hvis tom stabel
	 */
	public boolean erTom();

	/**
	 * Returnerer antall elementer p� stabelen.
	 * 
	 * @return antall element p� stabelen
	 */
	public int antall();

}
