package Aeroporto;

import java.util.Random;

public class Fila {
	private Nodo inicio = null;
	private Nodo fim;
	private int limite = 3;
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
	public void aterrissar1(Nodo Aviao) {
		if(temEspaco()) {
			//Nodo novo = new Nodo(ID);
			if(estaVazio()) {
				inicio = Aviao;
				fim = Aviao;
			}else {
				fim.setProx(Aviao);
				fim = Aviao;
			}
			
			Random a = new Random();
			int tempo_aviao = 0;
			tempo_aviao = a.nextInt(1,20);
			Aviao.setID(ID1);
			Aviao.setTempo(tempo_aviao);
			tamanho++;
			ID1+=2;
			System.out.println("Avião de ID: "+Aviao.getID()+" e Combustível: "+Aviao.getTempo()+" entrou na fila de aterrissagem 1.");
		}else {
			System.out.println("Fila cheia!");
		}
	}
	
	public void aterrissar2(Nodo Aviao) {
		if(temEspaco()) {
			//Nodo novo = new Nodo(ID);
			if(estaVazio()) {
				inicio = Aviao;
				fim = Aviao;
			}else {
				fim.setProx(Aviao);
				fim = Aviao;
			}
			
			Random a = new Random();
			int tempo_aviao = 0;
			tempo_aviao = a.nextInt(1,20);
			Aviao.setID(ID1);
			Aviao.setTempo(tempo_aviao);
			tamanho++;
			ID1+=2;
			System.out.println("Avião de ID: "+Aviao.getID()+" e Combustível: "+Aviao.getTempo()+" entrou na fila de aterrissagem 2.");
		}else {
			System.out.println("Fila cheia!");
		}
	}
	
	public void decolar1(Nodo Aviao) {
		if(temEspaco()) {
			//Nodo novo = new Nodo(ID);
			if(estaVazio()) {
				inicio = Aviao;
				fim = Aviao;
			}else {
				fim.setProx(Aviao);
				fim = Aviao;
			}

			Aviao.setID(ID2);
			tamanho++;
			ID2+=2;
			System.out.println("Avião de ID: "+Aviao.getID()+" entrou na fila de decolagem 1.");
		}else {
			System.out.println("Fila cheia!");
		}
	}
	
	public void decolar2(Nodo Aviao) {
		if(temEspaco()) {
			//Nodo novo = new Nodo(ID);
			if(estaVazio()) {
				inicio = Aviao;
				fim = Aviao;
			}else {
				fim.setProx(Aviao);
				fim = Aviao;
			}

			Aviao.setID(ID2);
			tamanho++;
			ID2+=2;
			System.out.println("Avião de ID: "+Aviao.getID()+" entrou na fila de decolagem 2.");
		}else {
			System.out.println("Fila cheia!");
		}
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
		if(estaVazio()) {
			return;
		}
		Nodo aux = inicio;
		while(aux != null) {
			System.out.print("ID: "+ aux.getID()+" Combustivel: "+aux.getTempo()+" ");
			aux = aux.getProx();
		}
		System.out.println();
		
	}
	
	public void mostraListaD() {
		if(estaVazio()) {
			return;
		}
		Nodo aux = inicio;
		while(aux != null) {
			System.out.print("ID: "+ aux.getID());
			aux = aux.getProx();
		}
		System.out.println();
		
	}
	
	public void decolar() {
		
		if(inicio == null) return;
		
		if(inicio != null){
				inicio = inicio.getProx();
				System.out.println("Aviao decolou.");
				return;
			}
		}
	
	public void aterrissarMenor() {

		int menor = 100;
	
		if(inicio == null) return;
		
		Nodo aux = inicio;
		Nodo aux2 = inicio;
		while(aux != null) {
			if(aux.getTempo() < menor) {
				menor = aux.getTempo();
				aux = aux.getProx();
			}
		}
		if(inicio != null) {
			if(inicio.getTempo()== menor) {
				inicio = inicio.getProx();
				System.out.println("Avião de menor combustível aterrissou.");				
				return;
			}
		}
		if(aux2 != null) {
		while(aux2.getProx() != null) {
			if(aux2.getProx().getTempo()==menor) {
				aux2.setProx(aux2.getProx().getProx());
				System.out.println("Avião de menor combustível aterrissou.");
				return;
			}
			aux2 = aux2.getProx();
		}
		return;
		}
	}
	
	
	/*
	public void removerMenor(Fila fila) {
		
		Nodo aux = inicio;
		Nodo meno = null;
		
		int menor = 21;
		
		while(aux.getProx() != null) {
			if(aux.getTempo() < menor) {
				menor = aux.getTempo();
				meno = aux;
			}
			aux = aux.getProx();
			
		}
		
		while() 
		

		inicio = inicio.getProx();

	}
	
	*/
}