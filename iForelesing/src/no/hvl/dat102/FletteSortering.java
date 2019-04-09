package no.hvl.dat102;

public class FletteSortering {
	public static void main(String[] args) {
		int[] tabA = {1, 3, 6, 7};
		int[] tabB = {2, 4, 5, 8, 9};
		int[] tabC = new int[tabA.length + tabB.length];
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		while (a < tabA.length && b < tabB.length) {
			if (tabA[a] <= tabB[b]) {
				tabC[c] = tabA[a];
				a++;
			} else {
				tabC[c] = tabB[b];
				b++;
			}
			c++;
		}
		
		if (a < tabA.length) {
			for (int i = a; i < tabA.length; i++) {
				tabC[c] = tabA[i];
				c++;
			}
		} else {
			for (int i = b; i < tabB.length; i++) {
				tabC[c] = tabB[i];
				c++;
			}
		}
		
		for (int i = 0; i < tabC.length; i++) {
			System.out.print(tabC[i] + " ");
		}
	}
}