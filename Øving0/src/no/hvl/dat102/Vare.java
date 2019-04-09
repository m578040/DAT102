package no.hvl.dat102;
import static javax.swing.JOptionPane.*;
import static java.lang.Double.*;

public class Vare {
	private int varenummer;
	private String navn;
	private double pris;
	
	public Vare() {
		this.varenummer = 0;
		this.navn = null;
		this.pris = 0.0;
	}
	
	public Vare(int varenummer) {
		this.varenummer = varenummer;
	}
	
	public Vare(int varenummer, String navn, double pris) {
		this.varenummer = varenummer;
		this.navn = navn;
		this.pris = pris;
	}
	
	public void setVarenummer(int varenummer) {
		this.varenummer = varenummer;
	}
	
	public int getVarenummer() {
		return varenummer;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setPris(double pris) {
		this.pris = pris;
	}
	
	public double getPris() {
		return pris;
	}
	
	public void lesVare(int varenummer) {
		this.varenummer = varenummer;
		
		navn = showInputDialog("Gi navn:");
		double prisen = parseDouble(showInputDialog("Gi pris:"));
		
		while (prisen < 0.0) {
			showMessageDialog(null, "Negativt tall, prøv på nytt");
			prisen = parseDouble(showInputDialog("Gi pris:"));
		}
		
		pris = prisen;
	}
}