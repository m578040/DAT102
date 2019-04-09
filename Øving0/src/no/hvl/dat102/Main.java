package no.hvl.dat102;

public class Main {
	public static void main(String[] args) {
		Butikk b = new Butikk("Min butikk", 100);
		
		b.leggInnNyVare(12);
		b.leggInnNyVare(28);
		b.leggInnNyVare(4);
		
		b.grossInnkjøp(12, 50);
		b.grossInnkjøp(28, 5);
		b.grossInnkjøp(4, 30);
		
		b.lesPris(12);
		b.lesPris(28);
		b.lesPris(4);
		
		System.out.println(b.salgsVerdi());
		
		b.slettVare(4);
		
		b.detaljSalg(12);
		b.detaljSalg(28);
		
		System.out.println(b.salgsVerdi());
		
		System.out.println();
		
		System.out.println(b.toString());
	}
}