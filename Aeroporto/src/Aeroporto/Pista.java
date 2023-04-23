package Aeroporto;

public class Pista {
	private Nodo inicio = null;
	private int limite = 3;
	private int tamanho = 0;
	int tempo = 0;
	
	public Pista() {

	}
	public Pista(int limite) {
		this.limite=limite;
	}
	public boolean estaVazio() {
		return tamanho == 0;
	}
	public boolean temEspaco() {
		return limite >= tamanho;
	}
	public int getInicio() {
		if(!estaVazio()) {
			return inicio.getID();
		}else {
			System.out.println("Fila está vazia!");
			return -1;
		}
	}
	
	
}