package no.hvl.dat102.oppgave1;

public class HanoiTårn {
	private int totaleDisker;
	private static long antallFlytt;

	public HanoiTårn(int disker) {
		totaleDisker = disker;
		antallFlytt = 0;
	}

	public void loes() {
		flyttTaarn(totaleDisker, 1, 2, 3);
	}

	private void flyttTaarn(int diskAnt, int start, int slutt, int temp) {
		if (diskAnt == 1) {
			 antallFlytt++;
		} else {
			 flyttTaarn(diskAnt-1, start, temp, slutt);
			 antallFlytt++;
			 flyttTaarn(diskAnt-1, temp, slutt, start);
		}
	}
	
	public static void main(String[] args) {
		HanoiTårn taarn1 = new HanoiTårn(32);
		
		double start = System.nanoTime();
		taarn1.loes();
		double slutt = System.nanoTime();
		double tid = (slutt - start) / 1000000;
		
		System.out.println("Antall flytt: " + antallFlytt);
		System.out.println("Tid brukt: " + tid + "ms");
		
	}
}