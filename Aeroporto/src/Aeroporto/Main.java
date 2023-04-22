package Aeroporto;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		int tempo = 0;
		boolean vai = true;
		
		Pista Pista1 = new Pista();
		Pista Pista2 = new Pista();
		
		Fila Aterrissagem1 = new Fila();
		Fila Aterrissagem2 = new Fila();
		
		Fila Decolagem1 = new Fila();
		Fila Decolagem2 = new Fila();
	
		Random r = new Random();
		int entrada = 0;
		int pista = 0;
		
		while (vai) {
			tempo++;
			entrada = r.nextInt(0,3);
			pista = r.nextInt(0,3);

			
			for(int i = 0; i < entrada; i++) {
				Nodo Aviao = new Nodo();
				if(pista == 1) {
					Pista1.entrarAterrissagem1(Aviao, Aterrissagem1);
					tempo++;
					System.out.println(tempo);
				}else {
					Pista2.entrarAterrissagem2(Aviao, Aterrissagem2);
					tempo++;
					System.out.println(tempo);
				}
			}
			entrada = r.nextInt(0,3);
			pista = r.nextInt(1,3);
			for(int i = 0; i < entrada; i++) {
				Nodo Aviao = new Nodo();
				if(pista == 1) {
					Pista1.entrarDecolagem1(Aviao, Decolagem1);		
				}else {
					Pista2.entrarDecolagem2(Aviao, Decolagem2);
				}
			}
			tempo++;
			
			Aterrissagem1.aterrissarMenor();
			Aterrissagem2.aterrissarMenor();
			Decolagem1.decolar();
			Decolagem2.decolar();
			Aterrissagem1.mostraListaA();
			Aterrissagem2.mostraListaA();
			Decolagem1.mostraListaD();
			Decolagem2.mostraListaD();
			
			vai = false;
			}	
		
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
