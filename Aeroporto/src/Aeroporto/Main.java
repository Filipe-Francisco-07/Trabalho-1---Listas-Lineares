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
		int tempo_final_dec = 0;
		int tempo_final_ate = 0;
		int tempo_ate = 0;
		int num_dec = 0;
		int num_ate = 0;
		int choose = 0;
		
		// supondo que a reserva seja de 5 unidades de tempo.
		int reserva = 0;
		
		while (vai) {
			choose++;
			tempo++;	
			entrada = r.nextInt(1,3);
			
			System.out.println("tempo: "+tempo);
			
			// criando de 0 a 2 entradas de aterrissagem.
			for(int i = 0; i < entrada; i++) {
				tempo_ar = r.nextInt(1,21);
				ID1+=2;
				if(Aterrissagem1.getTamanho() < Aterrissagem2.getTamanho()){
					Aterrissagem1.aterrissar(ID1,tempo_ar,tempo);
					tempo_ate += tempo;
				}else if(Aterrissagem2.getTamanho() < Aterrissagem1.getTamanho()){
					Aterrissagem2.aterrissar(ID1,tempo_ar,tempo);
					tempo_ate += tempo;
				}else {
					Aterrissagem1.aterrissar(ID1,tempo_ar,tempo);
					tempo_ate += tempo;
				}
			}
			
			entrada = r.nextInt(1,3);
			
			// criando de 0 a 2 entradas de aterrissagem.
			for(int i = 0; i < entrada; i++) {
				Nodo Aviao = new Nodo();
				Aviao.setID(ID2);
				ID2+=2;
				if(Decolagem1.getTamanho() < Decolagem2.getTamanho()){
					Decolagem1.decolar(ID2,tempo);
					tempo_dec += tempo;
				}else if(Decolagem2.getTamanho() < Decolagem1.getTamanho()){
					Decolagem2.decolar(ID2,tempo);
					tempo_dec += tempo;
				}else {
					tempo_dec += tempo;
					Decolagem1.decolar(ID2,tempo);
				}
			}		
			
			//diminuindo o combustivel dos avioes que estao no ceu.
			
			Aterrissagem1.diminuirCombustivel();
			Aterrissagem2.diminuirCombustivel();
			
			//mudar
				
			if(choose % 2 == 0) {
				if(Aterrissagem1.qntMenor()) {
					reserva++;
				}
				num_ate++;
				Aterrissagem1.aterrissarMenor();
				num_dec++;
				Decolagem1.decolar();
			}else {
				if(Aterrissagem2.qntMenor()) {
					reserva++;
				}
				num_ate++;
				Aterrissagem2.aterrissarMenor();
				num_dec++;
				Decolagem2.decolar();
			}
	
			//mostrando o conteudo das listas
			
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
				
			//opcao de refazer o looping ou terminar.
			
			if(opt == 1) {
				tempo_final_ate = (tempo_ate- tempo);
				tempo_final_dec = (tempo_dec - tempo);				
				System.out.println("Tempo médio de espera para decolagem: "+(tempo_final_dec/num_dec));
				System.out.println("Tempo médio de espera para aterrissagem: "+(tempo_final_ate/num_ate));
				System.out.println("Fim do programa.");
				
				vai = false;
			}
		}	

		input.close();

	}
}
