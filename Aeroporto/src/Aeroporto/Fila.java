package Aeroporto;

public class Fila {
	private Nodo inicio = null;
	private Nodo fim;
	private int limite = 100000;
	private int tamanho = 0;

	
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
			System.out.println("Fila esta vazia!");
			return -1;
		}
	}
	
	public int getTamanho() {
		return tamanho;
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
			System.out.println("Aviao de ID: "+Aviao.getID()+" Combustivel: "+Aviao.getTempo()+" entrou na fila de aterrissagem.");
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
			System.out.println("Aviao de ID: "+Aviao.getID()+" entrou na fila de decolagem.");
		}else {
			System.out.println("Fila de decolagem cheia!");
		}
	}
	
	public void mostraListaA() {
	    if (inicio == null) {
	        System.out.println("A fila esta vazia.");
	        return;
	    }
	    Nodo atual = inicio;
	    while (atual != null ) {
	        System.out.println("ID: "+atual.getID()+ " Combustivel: "+atual.getTempo() );
	        if(atual == fim) {
	        	break;
	        }
	        atual = atual.getProx();
	        }
	}
	
	public void mostraListaD() {
		if (inicio == null) {
		    System.out.println("A fila esta vazia.");
		    return;
		}    
		Nodo atual = inicio;
		    
		while (atual != null) {
		    System.out.println("ID: "+atual.getID());
		    if(atual == fim) {
	        	break;
	        }
		    atual = atual.getProx();
		}
	}
	
	
	public void decolagem() {
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
			if(aux.getTempo() >= 1) {
				aux.setTempo(aux.getTempo()-1); 
			}
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
	    System.out.println("Aviao de combustível "+menor+" aterrissou.");
	    return;
	}
	
}