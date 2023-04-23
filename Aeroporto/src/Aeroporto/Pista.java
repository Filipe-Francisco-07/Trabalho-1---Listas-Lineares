package Aeroporto;

import java.util.Random;

public class Pista {
	private Nodo inicio = null;
	private Nodo fim;
	private int limite = 3;
	private int tamanho = 0;
	private int ID1 = 1;
	private int ID2 = 2;
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
	
	public Integer remover() {
		if(estaVazio()) {
			return null;
		}
		int valor = inicio.getID();
		inicio = inicio.getProx();
		tamanho--;
		if(estaVazio()) {
			fim = null;
		}
		return valor;
	}
	
	
}