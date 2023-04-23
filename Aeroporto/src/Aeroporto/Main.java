package Aeroporto;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
				
		int tempo = 0;
		int desc_tempo = 0;
		boolean vai = true;
		
		Fila Aterrissagem1 = new Fila();
		Fila Aterrissagem2 = new Fila();
		
		Fila Decolagem1 = new Fila();
		Fila Decolagem2 = new Fila();
	
		Random r = new Random();
		int entrada = 0;
		int pista = 0;
		int choose = 0;
		int ID1 = 1;
		int ID2 = 2;
		int tempo_ar = 0;
		// supondo que a reserva seja de 5 unidades de tempo.
		int reserva = 0;
		
		while (vai) {
			choose++;
			tempo++;
			desc_tempo--;
			
			entrada = r.nextInt(1,3);
			pista = r.nextInt(1,3);
			
			System.out.println("tempo: "+tempo);
			
			// criando de 0 a 2 entradas de aterrissagem.
			for(int i = 0; i < entrada; i++) {
				tempo_ar = r.nextInt(1,20);
				ID1+=2;
				if(pista == 1) {
					Aterrissagem1.aterrissar(ID1,tempo_ar);
				}else {
					Aterrissagem2.aterrissar(ID1,tempo_ar);
				}
			}
			
			entrada = r.nextInt(0,3);
			pista = r.nextInt(0,3);
			for(int i = 0; i < entrada; i++) {
				Nodo Aviao = new Nodo();
				Aviao.setID(ID2);
				ID2+=2;
				if(pista == 1) {
					Decolagem1.decolar(ID2);
				}else {
					Decolagem2.decolar(ID2);
				}
			}
			// ok ate aq		
		
			if(!Aterrissagem1.estaVazio() && !Decolagem1.estaVazio()) {
				if(Aterrissagem1.qntMenor()) {
					reserva++;
				}
				Aterrissagem1.aterrissarMenor();
				Decolagem1.decolar();	
			}else if(!Aterrissagem2.estaVazio() && !Decolagem2.estaVazio()){					
				if(Aterrissagem2.qntMenor()) {
					reserva++;
				}
				Aterrissagem2.aterrissarMenor();
				Decolagem2.decolar();
			}else if(!Aterrissagem1.estaVazio() && !Decolagem2.estaVazio()) {
				if(Aterrissagem1.qntMenor()) {
					reserva++;
				}
				Aterrissagem1.aterrissarMenor();
				Decolagem2.decolar();
			}else if(!Aterrissagem2.estaVazio() && !Decolagem1.estaVazio()) {
				if(Aterrissagem2.qntMenor()) {
				reserva++;
				}
				Aterrissagem2.aterrissarMenor();
				Decolagem1.decolar();	
			}else if (!Aterrissagem1.estaVazio() && Decolagem1.estaVazio()){
				if(Aterrissagem1.qntMenor()) {
				reserva++;
				}
				Aterrissagem1.aterrissarMenor();
			}else if (!Aterrissagem2.estaVazio() && Decolagem1.estaVazio()){
				if(Aterrissagem2.qntMenor()) {
				reserva++;
				}
				Aterrissagem2.aterrissarMenor();
			}else if (!Aterrissagem1.estaVazio() && Decolagem2.estaVazio()){
				if(Aterrissagem1.qntMenor()) {
				reserva++;
				}
				Aterrissagem1.aterrissarMenor();
			}else if (!Aterrissagem2.estaVazio() && Decolagem2.estaVazio()){
				if(Aterrissagem2.qntMenor()) {
				reserva++;
				}
				Aterrissagem2.aterrissarMenor();
			}else if (!Decolagem1.estaVazio() && Aterrissagem1.estaVazio()){
				Decolagem1.decolar();	
			}else if (!Decolagem2.estaVazio() && Aterrissagem1.estaVazio()){
				Decolagem2.decolar();	
			}else if (!Decolagem1.estaVazio() && Aterrissagem2.estaVazio()){
				Decolagem1.decolar();	
			}else if (!Decolagem2.estaVazio() && Aterrissagem2.estaVazio()){
				Decolagem2.decolar();	
			}
				
			
			System.out.println("Lista de aterrissagem 1:");
			Aterrissagem1.mostraListaA();
			System.out.println("Lista de aterrissagem 2:");
			Aterrissagem2.mostraListaA();
			System.out.println("Lista de decolagem 1:");
			Decolagem1.mostraListaD();
			System.out.println("Lista de decolagem 2:");
			Decolagem2.mostraListaD();
			System.out.println("Aviões que pousaram na reserva: "+reserva);
				
			System.out.println("Digite 1 para parar ou qualquer coisa para continuar. ");
			int opt = input.nextInt();
				
			if(opt == 1) {
				System.out.println("Fim do programa. :(");
				vai = false;
			}
		}	
		
		/*
		Nodo Aviao1 = new Nodo();
		Nodo Aviao2 = new Nodo();
		Nodo Aviao3 = new Nodo();
		Nodo Aviao4 = new Nodo();
		
		Pista1.entrarAterrissagem1(Aviao1, Aterrissagem1);
		Pista2.entrarAterrissagem2(Aviao1, Aterrissagem2);
		
		Pista1.entrarDecolagem1(Aviao1, Decolagem1);	
		Pista2.entrarDecolagem2(Aviao1, Decolagem2);	
		
		
		Aterrissagem1.aterrissarMenor();
		Decolagem1.decolar();	

		Aterrissagem2.aterrissarMenor();
		Decolagem2.decolar();
		
		
		System.out.println("Lista de aterrissagem 1:");
		Aterrissagem1.mostraListaA();
		System.out.println("Lista de aterrissagem 2:");
		Aterrissagem2.mostraListaA();
		System.out.println("Lista de decolagem 1:");
		Decolagem1.mostraListaD();
		System.out.println("Lista de decolagem 2:");
		Decolagem2.mostraListaD();
		
		*/

		input.close();
		}
						
		/*A cada unidade de tempo, de zero a duas aeronaves podem chegar às filas de decolagem, e de
zero a duas aeronaves podem chegar às prateleiras. A cada unidade de tempo cada pista pode
ser usada para um pouso ou uma decolagem. Se alguma(s) aeronaves estiverem com falta de
combustível ela(s) terão prioridade para aterrissar. A cada unidade de tempo no máximo dois
aviões poderão estar nesta desagradável situação. Utilize inteiros pares (ímpares) sucessivos
para o ID dos aviões chegando às filas de decolagem (aterrissagem). A cada unidade de tempo,
assuma que os aviões entrem nas filas antes que aterrissagens ou decolagens ocorram. Tente
projetar um algoritmo que não permita o crescimento excessivo das filas de aterrissagem ou
decolagem. Coloque os aviões que chegam no final das filas, que não devem ser reordenadas.
	*/
		

}
