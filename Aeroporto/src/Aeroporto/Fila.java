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
			tempo_aviao = a.nextInt(10,100);
			Aviao.setID(ID1);
			Aviao.setTempo_restante(tempo_aviao);
			tamanho++;
			ID1+=2;
			System.out.println("Avião de ID: "+Aviao.getID()+" e Combustível: "+Aviao.getTempo_restante()+" entrou na fila de aterrissagem 1.");
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
			tempo_aviao = a.nextInt(10,100);
			Aviao.setID(ID1);
			Aviao.setTempo_restante(tempo_aviao);
			tamanho++;
			ID1+=2;
			System.out.println("Avião de ID: "+Aviao.getID()+" e Combustível: "+Aviao.getTempo_restante()+" entrou na fila de aterrissagem 2.");
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
		int valor = inicio.getID();
		inicio = inicio.getProx();
		tamanho--;
		if(estaVazio()) {
			fim = null;
		}
		return valor;
	}
	
	
}