package Aeroporto;

import java.util.Random;

public class Fila {
	private Nodo inicio = null;
	private Nodo fim;
	private int limite = 100;
	private int tamanho = 0;
	private int ID1 = 1;
	private int ID2 = 2;
	
	public Fila() {
	}
	public Fila(int limite) {
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
	
	public void inserir(int dado) {
		if(temEspaco()) {
			Nodo novo = new Nodo(dado);
			if(estaVazio()) {
				inicio = novo;
				fim = novo;
			}else {
				fim.setProx(novo);
				fim = novo;
			}
			tamanho++;
		}else {
			System.out.println("Fila cheia!");
		}
	}
	
	public void aterrissar1(Nodo Aviao) {
			if(estaVazio()) {
				inicio = Aviao;
				fim = Aviao;
			}else {
				fim.setProx(Aviao);
				fim = Aviao;
			}
			tamanho++;
			System.out.println("Avião de ID: "+Aviao.getID()+" e Combustível: "+Aviao.getTempo()+" entrou na fila de aterrissagem 1.");
	}
	
	public void aterrissar2(Nodo Aviao) {
			if(estaVazio()) {
				inicio = Aviao;
				fim = Aviao;
			}else {
				fim.setProx(Aviao);
				fim = Aviao;
			}
			tamanho++;
			System.out.println("Avião de ID: "+Aviao.getID()+" e Combustível: "+Aviao.getTempo()+" entrou na fila de aterrissagem 2.");
	}
	
	public void decolar1(Nodo Aviao) {

			if(estaVazio()) {
				inicio = Aviao;
				fim = Aviao;
			}else {
				fim.setProx(Aviao);
				fim = Aviao;
			}
			tamanho++;
			System.out.println("Avião de ID: "+Aviao.getID()+" entrou na fila de decolagem 1.");
	}
	
	public void decolar2(Nodo Aviao) {
			if(estaVazio()) {
				inicio = Aviao;
				fim = Aviao;
			}else {
				fim.setProx(Aviao);
				fim = Aviao;
			}
			tamanho++;
			System.out.println("Avião de ID: "+Aviao.getID()+" entrou na fila de decolagem 2.");
	}
	
	public Integer remover() {
		if(estaVazio()) {
			return null;
		}
	
		inicio = inicio.getProx();
		tamanho--;
		if(estaVazio()) {
			fim = null;
		}
		return 1;
	}
	
	public void mostraListaA() {
		Nodo aux = inicio;
		while(aux != null) {
			System.out.println("ID: "+ aux.getID()+" Combustivel: "+aux.getTempo()+" ");
			aux = aux.getProx();
		}
		System.out.println();
		return;
		
	}
	
	public void mostraListaD() {
		Nodo aux = inicio;
		while(aux != null) {
			System.out.println("ID: "+ aux.getID());
			aux = aux.getProx();
		}
		System.out.println();
		return;
		
	}
	
	public void decolar() {
		
		if(estaVazio()) {
			return;
		}
		
		Nodo aux = inicio;
		if(aux != null){
				aux = aux.getProx();
				tamanho--;
				System.out.println("Aviao decolou.");
				
				return;
		}
		if(estaVazio()) {
			fim = null;
			return;
		}
		return;
		}
	
	public void diminuirCombustivel() {	
		if(inicio == null) return;
		
		Nodo aux = inicio;

		aux = inicio;

		while(aux != null) {
				aux.setTempo(aux.getTempo()-1); 
				aux.setProx(aux.getProx().getProx());
				aux = aux.getProx();
		}
		return;
	}
	
	public boolean qntMenor() {
	
		int menor = 100;
		
		if(inicio == null) return false;
		
		Nodo aux = inicio;
		while(aux != null) {
			if(aux.getTempo() < menor) {
				menor = aux.getTempo();
				aux = aux.getProx();
			}
		}
		if(menor <= 5) {
			return true;
		}
		return false;
	}
	
	public void aterrissarMenor() {

		int menor = 100;
	
		if(inicio == null) return;
		
		Nodo aux = inicio;
		while(aux != null) {
			if(aux.getTempo() < menor) {
				menor = aux.getTempo();
				aux = aux.getProx();
			}
		}
		aux = inicio;
		if(inicio != null) {
			if(inicio.getTempo()== menor) {
				inicio = inicio.getProx();
				System.out.println("Avião de menor combustível aterrissou.");				
				return;
			}
		}
		aux = inicio;
		
		while(inicio.getProx() != null) {
			if(inicio.getProx().getTempo()==menor) {
				inicio.setProx(inicio.getProx().getProx());
				System.out.println("Avião de menor combustível aterrissou.");
				return;
			}
			inicio = inicio.getProx();
		}
		return;
	}
	
}