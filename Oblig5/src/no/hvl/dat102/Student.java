package no.hvl.dat102;

public class Student {
	private int studentNr;
	private String navn;
	
	public Student(int studentNr, String navn) {
		this.studentNr = studentNr;
		this.navn = navn;
	}
	
	public int hashcode() {
		return Integer.toString(studentNr).hashCode();
	}
	
	public static void main(String[] args) {
		Student s1 = new Student(10, "Ole");
		Student s2 = new Student(10, "Ole");
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println();
		System.out.println(s1.hashcode());
		System.out.println(s2.hashcode());
	}
}