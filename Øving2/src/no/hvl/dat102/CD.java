package no.hvl.dat102;

public class CD {
	private int CDnr;
	private String artist;
	private String tittel;
	private int lansering;
	private Sjanger sjanger;
	private String plateselskap;
	
	public CD() {
		CDnr = 0;
		artist = null;
		tittel = null;
		lansering = 0;
		sjanger = null;
		plateselskap = null;
	}
	
	public CD(int CDnr, String artist, String tittel, int lansering, Sjanger sjanger, String plateselskap) {
		this.CDnr = CDnr;
		this.artist = artist;
		this.tittel = tittel;
		this.lansering = lansering;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}
	
	public int getCDnr() {
		return CDnr;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	
	public int getLansering() {
		return lansering;
	}
	
	public String getPlateselskap() {
		return plateselskap;
	}
}