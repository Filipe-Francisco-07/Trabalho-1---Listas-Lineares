package Aeroporto;

public class Nodo {
	
	private int ID;
	private int tempo;
	private int tempo_entrada;
	private int tempo_saida;
	
	private Nodo Prox;

	public int getTempo_entrada() {
		return tempo_entrada;
	}

	public void setTempo_entrada(int tempo_entrada) {
		this.tempo_entrada = tempo_entrada;
	}

	public int getTempo_saida() {
		return tempo_saida;
	}

	public void setTempo_saida(int tempo_saida) {
		this.tempo_saida = tempo_saida;
	}

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
	
	public Nodo(int ID, int tempo, int tempo_entrada) {
		this.ID = ID;
		this.tempo = tempo;
		this.tempo_entrada = tempo_entrada;
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

