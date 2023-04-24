package Aeroporto;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
				
		int tempo = 0;
		boolean vai = true;
		
		Fila Aterrissagem1 = new Fila();
		Fila Aterrissagem2 = new Fila();
		
		Fila Decolagem1 = new Fila();
		Fila Decolagem2 = new Fila();
	
		Random r = new Random();
		int entrada = 0;
		int ID1 = 1;
		int ID2 = 2;
		int tempo_ar = 0;
		int tempo_dec = 0;
		int tempo_ate = 0;
		int num_dec = 0;
		int num_ate = 0;
		int choose = 1;
		
		// supondo que a reserva seja de 5 unidades de tempo.
		int reserva = 0;
		
		while (vai) {
			choose++;
			tempo++;	
			entrada = r.nextInt(1,3);
			
			System.out.println("tempo: "+tempo);
			
			// criando de 0 a 2 entradas de aterrissagem.
	

			tempo_ar = r.nextInt(8,21);
			if(entrada == 1) {			
				if(Aterrissagem2.getTamanho() < Aterrissagem1.getTamanho()) {
					Aterrissagem2.aterrissar(ID1,tempo_ar);
					tempo_ate += tempo;
					ID1+=2;
					tempo_ar = r.nextInt(8,21);
				}else {
					Aterrissagem1.aterrissar(ID1,tempo_ar);
					tempo_ate += tempo;
					ID1+=2;
					tempo_ar = r.nextInt(8,21);
				}
			}else if(entrada == 2){
				Aterrissagem1.aterrissar(ID1,tempo_ar);
				tempo_ate += tempo;
				ID1+=2;
				tempo_ar = r.nextInt(8,21);
				Aterrissagem2.aterrissar(ID1,tempo_ar);
				tempo_ate += tempo;
				ID1+=2;
				tempo_ar = r.nextInt(8,21);
			}else {
				System.out.println("Sem aterrissagens no tempo "+tempo);
			}
			
			entrada = r.nextInt(1,3);
			
			// criando de 0 a 2 entradas de decolagem.
			if(entrada == 1) {
				if(Decolagem2.getTamanho() < Decolagem1.getTamanho()) {
					Decolagem2.decolar(ID2);
					tempo_dec += tempo;
					ID2+=2;
				}else{
					Decolagem1.decolar(ID2);
					tempo_dec += tempo;
					ID2+=2;
				}
			}else if(entrada == 2){
				Decolagem1.decolar(ID2);
				tempo_dec += tempo;
				ID2+=2;
				Decolagem2.decolar(ID2);
				tempo_dec += tempo;
				ID2+=2;
			}else {
				System.out.println("Sem decolagens no tempo "+tempo);
			}
		
			//diminuindo o combustivel dos avioes que estao no ceu.
			
			Aterrissagem1.diminuirCombustivel();
			Aterrissagem2.diminuirCombustivel();
			
			//removendo os avioes que decolam e aterrissam da fila (1 de cada a cada unidade de tempo).
			
			boolean dois = true;
			
			while(dois) {
			boolean p1 = false;
			boolean p2 = false;
				if(choose % 2 == 0) {
					if(!Aterrissagem1.estaVazio()) {
						if(Aterrissagem1.qntMenor()) {
							reserva++;
						}				
						Aterrissagem1.aterrissarMenor();
						num_ate++;
						p1 = true;
					}else if(!Aterrissagem2.estaVazio()) {
						if(Aterrissagem2.qntMenor()) {
							reserva++;
						}				
						Aterrissagem2.aterrissarMenor();
						num_ate++;
						p1 = true;{
						}
					}
					
					if(!Decolagem1.estaVazio()) {				
						Decolagem1.decolagem();
						num_dec++;
						p2 = true;
					}else if(!Decolagem2.estaVazio()) {				
						Decolagem2.decolagem();
						num_dec++;
						p2 = true;
					}				
					if(p1 && p2) {
						dois = false;
						break;
					}
				}
				if(choose % 2 != 0) {
					if(!Decolagem2.estaVazio()) {				
						Decolagem2.decolagem();
						num_dec++;
						p2 = true;
					}else if(!Decolagem1.estaVazio()) {
						Decolagem1.decolagem();
						num_dec++;
						p2 = true;
					}
					if(!Aterrissagem2.estaVazio()) {
						if(Aterrissagem2.qntMenor()) {
							reserva++;
						}				
						Aterrissagem2.aterrissarMenor();
						num_ate++;
						p1 = true;
					}else if(!Aterrissagem1.estaVazio()) {
						if(Aterrissagem1.qntMenor()) {
							reserva++;
						}				
						Aterrissagem1.aterrissarMenor();
						num_ate++;
						p1 = true;
					}
					if(p1 && p2) {
						dois = false;
						break;
					}
				}
			}
			//mostrando o conteudo das listas
			
			System.out.println("Lista de aterrissagem 1:");
			Aterrissagem1.mostraListaA();
			System.out.println("Lista de decolagem 1:");
			Decolagem1.mostraListaD();
			System.out.println("Lista de aterrissagem 2:");
			Aterrissagem2.mostraListaA();
			System.out.println("Lista de decolagem 2:");
			Decolagem2.mostraListaD();
			System.out.println("Avioes que pousaram na reserva: "+reserva);
			System.out.println("Tempo medio de espera para decolagem: "+(tempo_dec/num_dec));
			System.out.println("Tempo medio de espera para aterrissagem: "+(tempo_ate/num_ate));
			System.out.println();
			System.out.println("Digite 1 para parar ou qualquer coisa para continuar. ");
			int opt = input.nextInt();
	
				
			//opcao de refazer o looping ou terminar.
			
			if(opt == 1) {
				System.out.println("Fim do programa.");			
				vai = false;
			}
		}	

		input.close();

	}
}
