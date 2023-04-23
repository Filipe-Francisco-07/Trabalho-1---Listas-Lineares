package Aeroporto;

public class Nodo {
	
	private int ID;
	private int tempo;
	private Nodo Prox;
	
	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public Nodo() {
		this.Prox = null;
	}
	
	public Nodo(int ID) {
		this.ID = ID;
		this.Prox = null;
	}
	
	public Nodo(int ID, int tempo) {
		this.ID = ID;
		this.tempo = tempo;
		this.Prox = null;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Nodo getProx() {
		return Prox;
	}
	public void setProx(Nodo prox) {
		Prox = prox;
	}
	
}

