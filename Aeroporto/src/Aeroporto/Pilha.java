package Aeroporto;

public class Pilha {
	private Nodo topo;
	private int tamanho = 0;
	private int limite = 0;
	
	public Pilha(int limite) {
		this.limite=limite;
	}
	public int getTopo() {
		return topo.getID();
	}
	public boolean estaVazio() {
		return tamanho == 0;
	}
	public boolean temEspaco() {
		return limite > tamanho;
	}
	// inserir (push)
	public void push(int dado) {
		if(temEspaco()) {
			Nodo novo = new Nodo(dado);
			novo.setProx(topo);
			topo = novo;
			tamanho++;
		}else {
			System.out.println("Pilha cheia!!!");
		}
	}
	// remover (pop)
	public void pop() {
		if(!estaVazio()) {
			System.out.println(topo.getID()+" foi retirado da pilha!");
			topo = topo.getProx();
			tamanho--;
		}else {
			System.out.println("Pilha está vazia!");
		}
	}
}