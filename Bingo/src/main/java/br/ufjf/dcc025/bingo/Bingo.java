package br.ufjf.dcc025.bingo;

import java.util.Scanner;

/**
 *
 * @author nelio
 */
public class Bingo {

    private static final int TAM = 50;
    private static boolean bingo = false;
    private static Card card[] = new Card[TAM];
    public static int tamanho = 0;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("****************************");
        System.out.println("**** BEM VINDO AO BINGO ****");
        System.out.println("****************************");

        boolean game = true;
        int accept = 0;
        int drawnNumber = 0;
        int number = 0;
        
       
        do {
            System.out.println("Digite quantos jogadores irão participar: ");
            int tamanho = teclado.nextInt();
            for (int i = 0; i < tamanho; i++) {
                card[i] = new Card();
            }
            do {
                for (int i = 0; i < tamanho; i++) {
                    System.out.println("Cartela " + (i + 1) + " abaixo: ");
                    card[i].showCard();
                }

                System.out.println("Digite 0 para encerrar o jogo, digite qualquer outro número para continuar!");
                number = teclado.nextInt();

                if (number == 0) {
                    break;
                }
                drawnNumber = card[0].drawNumber();
                System.out.println("*** Número Sorteado: " + drawnNumber + ":)");
                markCards(drawnNumber, tamanho);
            } while (!isBingo(tamanho));
            System.out.println("Deseja continuar o jogo ? Digite 1 para SIM e 2 para NÃO");
            accept = teclado.nextInt();
            if (accept != 1) {
                game = false;
                for(int i=0; i<tamanho; i++){
                    card[i] = null;   
                }
                bingo = false;
            }
        } while (game);
        System.out.println("Obrigado por jogar, até a próxima :)");

    }

    private static boolean isBingo(int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            if (card[i].checkBingo()) {
                bingo = true;
                System.out.println("Parabéns, a cartela " + (i+1) +  " foi completa. BINGOO!!");
                return true;
            }
        }
        return false;
    }

    private static void markCards(int numberDrawn, int tamanho) {
        for (int j = 0; j < tamanho; j++) {
            card[j].markNumber(numberDrawn, j);
        }
    }
}
