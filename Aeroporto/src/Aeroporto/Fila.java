package Aeroporto;

import java.util.Random;

public class Fila {
	private Nodo inicio = null;
	private Nodo fim;
	private int limite = 20;
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
	
	public void aterrissar(int ID, int tempo_ar) {
		if(temEspaco()) {
			Nodo Aviao = new Nodo(ID, tempo_ar);
			if(estaVazio()) {
				inicio = Aviao;
				fim = Aviao;
			}else {
				fim.setProx(Aviao);
				fim = Aviao;
			}
			tamanho++;
			System.out.println("Avião de ID: "+Aviao.getID()+" Combustivel: "+Aviao.getTempo()+" entrou na fila de aterrissagem.");
		}else {
			System.out.println("Fila de aterrissagem cheia!");
		}
	}
	
	public void decolar(int ID) {
		if(temEspaco()) {
			Nodo Aviao = new Nodo(ID);
			if(estaVazio()) {
				inicio = Aviao;
				fim = Aviao;
			}else {
				fim.setProx(Aviao);
				fim = Aviao;
			}
			tamanho++;
			System.out.println("Avião de ID: "+Aviao.getID()+" entrou na fila de decolagem.");
		}else {
			System.out.println("Fila de decolagem cheia!");
		}
	}
	
	public Integer remover() {
        if(estaVazio()) {
            return null;
        }
        int valor = inicio.getID();
        inicio = inicio.getProx();
        if(estaVazio()) {
            fim = null;
        }
        return valor;
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
        if(inicio != null) {
        	inicio = inicio.getProx();
        	tamanho--;
        }
        if(estaVazio()) {
            fim = null;
        }
        System.out.println("Aviao decolou.");
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
		int menor = 21;
		
		Nodo aux = inicio;
		while(aux != null) {
			if(aux.getTempo() < menor) {
				menor = aux.getTempo();
			}
			aux = aux.getProx();
		}
		
		if(menor <= 5) {
			return true;
		}
		return false;
	}
	
	public void aterrissarMenor() {
		int menor = 21;
		
	    if (estaVazio()) {
	        return;
	    }
	    
	    Nodo aux = inicio;
		while(aux != null) {
			if(aux.getTempo() < menor) {
				menor = aux.getTempo();
			}
			aux = aux.getProx();
		}
		
	    Nodo anterior = null;
	    Nodo atual = inicio;
	    Nodo menorNodo = inicio;
	    while (atual != null) {
	        if (atual.getTempo() < menorNodo.getTempo() && atual.getTempo() == menor) {
	            menorNodo = atual;
	        }
	        anterior = atual;
	        atual = atual.getProx();
	    }
	    if (menorNodo == inicio) {
	        inicio = inicio.getProx();
	    } else {
	        anterior.setProx(menorNodo.getProx());
	    }
	    tamanho--;
	    if (estaVazio()) {
	        fim = null;
	    }
	    System.out.println("Avião de combustível "+menor+" aterrissou.");
	    return;
	}
	
}