
package jogodaforca;

import java.util.Scanner;

/**
 *
 * @author Manfroi
 */
public class JogoDaForca {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// ------------ VARIAVEIS UTILZIADAS ------------
		String palavraJogo;
		String nomeJogador;

		// ------------------------ FIM ------------------------

		// ------------ PEGAR A PALAVRA E O NOME DO JOGADOR ------------

		System.out.println("Digite uma palavra...");
		palavraJogo = scanner.nextLine();
		for (int i = 0; i < 50; ++i)
                    
		System.out.println(); // vai inserir linhas para sumir a palavra digitada pelo usuario
		System.out.println("Digite o nome do jogador");
		nomeJogador = scanner.next();

                System.out.println(nomeJogador + " Você pode digitar uma letra por vez, ou se preferir pode digitar a palavra inteira"
                        + "\nmas lembresse que, se a palavra estiver errada você perde o jogo"
                        + "\nvocê tera 5 tentativas para tentar adivnhar a palavra."
                        + "\n --- BOA SORTE ---");
		// ------------------------ FIM ------------------------
		int quantidadePalavras = palavraJogo.length();

		char[] acertos = new char[palavraJogo.length()]; // cria um novo vetor com o tamanho da palavra digitada 
                                                                //  tambem controla os acertos do usuario 
                    for (int i = 0; i < acertos.length; i++) {

                            acertos[i] = 0;
                    }
                
		String letrasUtilziadas = "";

		char letra;

		System.out.println("\n A palavra contem " + quantidadePalavras + " letras\n");

		boolean ganhou = false;
		int tentativas = 5;

                    for (int i = 0; i < palavraJogo.length(); i++) {

                            System.out.print(" _ ");
                    }

		do {
			// System.out.println("\n");

			System.out.print("\n" + " Você tem " 
                                + tentativas + " tentativa" + "\n Já foram tentada as seguintes letras: "
                                + letrasUtilziadas +"\n a qualquer momento você pode digitar a palavra se souber \n\n Qual letra você deseja tentar agora ? ");

                    String digitado = scanner.next();                  
                        if (digitado.length() > 1) {
                            if (digitado.equals(palavraJogo)) {
				ganhou = true; // se o jogador digitar a palava toda e estiver certa ele ganha 
				break;
                            } else {
				tentativas = 0;
				break;
                            }
                        } else {
                            letra = digitado.toUpperCase().charAt(0);               
                            letrasUtilziadas += " " + digitado; // concatena a letra nas letras utilziadas
                            
                            
                            
		boolean perdeChance = true;
			for (int i = 0; i < palavraJogo.length(); i++) {
                            if (letra == palavraJogo.toUpperCase().charAt(i)){
                                acertos[i] = 1; // se entrar na condição o jogador acertou a letra 
				perdeChance = false;
                            }
                        }
                        
                            if (perdeChance) {                                    
				tentativas--;
                            }
			}
			System.out.println("\n");

			ganhou = true;
                            for (int i = 0; i < palavraJogo.length(); i++) {
				if (acertos[i] == 0) {
                                    System.out.print(" _ ");
                                    ganhou = false; // mostra o estado da palavra. se nao tiver a letra 
				} else { // mostra _ e se tiver a letra vai mostrar a letra 
					System.out.print(" " + palavraJogo.toUpperCase().charAt(i) + " ");
				}
                            }

			System.out.println("\n");

                    } while (!ganhou && tentativas > 0);

                        if (tentativas != 0) {
			System.out.println("\n\t *** Parabens *** " + nomeJogador + " você acertou. " + "\n Ainda te restou "
					+ tentativas + " tentativas");
                        } else {
                            System.out.println("\n\t Fim do jogo " + nomeJogador + " \n você não acertou a palavra : (" + palavraJogo + ")");
                        }
        }

}
