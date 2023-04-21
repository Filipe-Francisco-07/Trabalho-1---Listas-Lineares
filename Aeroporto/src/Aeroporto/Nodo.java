package Aeroporto;

public class Nodo {
	
	private int ID;
	private int tempo_restante;
	private int tempo_total;
	private int tipo;
	
	private Nodo Prox;
	
	public int getTempo_restante() {
		return tempo_restante;
	}

	public void setTempo_restante(int tempo_restante) {
		this.tempo_restante = tempo_restante;
	}

	public int getTempo_total() {
		return tempo_total;
	}

	public void setTempo_total(int tempo_total) {
		this.tempo_total = tempo_total;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Nodo() {
		this.Prox = null;
	}
	
	public Nodo(int ID) {
		this.ID = ID;
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

