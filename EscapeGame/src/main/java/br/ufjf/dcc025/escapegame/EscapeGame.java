package br.ufjf.dcc025.escapegame;

import java.util.Scanner;

/**
 *
 * @author nelio
 */
public class EscapeGame {
    private static Board board;
    
    public static void main(String[] args) {
        int linha, coluna, qtde = 0, gg, linAnterior, colAnterior;
        char sentido;
        boolean game = true, finalizado = true;
        Scanner teclado = new Scanner(System.in);
        System.out.println("**********************************");
        System.out.println("**** BEM VINDO AO ESCAPE GAME ****");
        System.out.println("**********************************");
        
        do{
           game = true;
           boolean flag = true;
           board = new Board();
           board.showBoard();
        
            do{    
                System.out.println("Digite o sentido que quer se mover e quantas casas: ");  
                
                do{
                    linAnterior = board.linAtual;
                    colAnterior = board.colAtual;
                    linha = board.linAtual;
                    coluna = board.colAtual;
                    System.out.println("Sentido: esquerda(e), cima(c), direita(d), baixo(b)");
                    sentido = teclado.next().charAt(0);
                    System.out.println("Quantas casas: ");
                    qtde = teclado.nextInt();
                    switch(sentido){
                        case 'e':
                            coluna -= qtde;
                            break;
                        case 'c':
                            linha -= qtde;
                            break;
                        case 'd':
                            coluna += qtde;
                            break;
                        case 'b':
                            linha += qtde;
                            break;
                        default:
                            System.out.println("Erro");
                    }      
                    if(linha < 0 || linha > 9 || coluna < 0 || coluna > 9){
                        System.out.println("Por favor digite valores válidos para o tabuleiro!");
                    }else{
                        board.linAtual = linha;
                        board.colAtual = coluna;
                        flag = false;
                    }
                }while(flag);
                
                if(board.ehValido(linAnterior, colAnterior, qtde, sentido)){
                    System.out.println("Essa não, você caiu em uma bomba!!! Game over");
                    game = false;
                    break;
                }else if(board.exitHere(board.linAtual, board.colAtual)){
                    System.out.println("Parabéns, você sobreviveu e chegou a saída!! :)");
                    game = false;
                    break;
                }else{
                    board.showBoard();
                }
            }while(game); 
            boolean passou = true;
            do{
                System.out.println("Digite 1 para jogar novamente ou 0 para encerrar o jogo");
                gg = teclado.nextInt();
                if(gg == 1 || gg == 0){
                   passou = false;
                }else{
                   passou = true;
                }
            }while(passou);
            if(gg == 1){
                finalizado = true;
            }else{
                finalizado = false;
            }
        }while(finalizado);
        
        
    }
}
