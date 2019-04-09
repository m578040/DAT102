package no.hvl.dat102;

public class KvikkSortering {
	public void kvikkSort(int[] tabell, int min, int maks) {
	    if (min < maks) {
	        int partisjonPos = partisjon(tabell, min, maks);
	 
	        kvikkSort(tabell, min, partisjonPos-1);
	        kvikkSort(tabell, partisjonPos+1, maks);
	    }
	}
	
	private int partisjon(int[] tabell, int min, int maks) {
	    int pivot = tabell[maks];
	    int i = (min-1);
	 
	    for (int j = min; j < maks; j++) {
	        if (tabell[j] <= pivot) {
	            i++;
	 
	            int temp = tabell[i];
	            tabell[i] = tabell[j];
	            tabell[j] = temp;
	        }
	    }
	 
	    int temp = tabell[i+1];
	    tabell[i+1] = tabell[maks];
	    tabell[maks] = temp;
	 
	    return i+1;
	}
}