package no.hvl.dat102;

public class BinaerTreNode<T> {
	private BinaerTreNode<T> venstre;
    private BinaerTreNode<T> hoyre;
    private T element;
 
    public BinaerTreNode(T element) {
        this.element = element;
    }
 
    public BinaerTreNode<T> getVenstre() {
        return venstre;
    }
    public void setVenstre(BinaerTreNode<T> venstre) {
        this.venstre = venstre;
    }
    public BinaerTreNode<T> getHoyre() {
        return hoyre;
    }
    public void setHoyre(BinaerTreNode<T> hoyre) {
        this.hoyre = hoyre;
    }
 
    public T getElement() {
        return element;
    }
}