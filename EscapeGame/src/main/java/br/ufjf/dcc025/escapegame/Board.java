package br.ufjf.dcc025.escapegame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author nelio
 */
public class Board {
    
    private int board[][] = new int[10][10];
    private boolean haveBomb[][] = new boolean [10][10];
    public Random random = new Random();
    public int linAtual = random.nextInt(10), colAtual = random.nextInt(10), linSaida = random.nextInt(10), colSaida = random.nextInt(10);
    
    Board(){
        int numBombs = 0, position = 0, cont = 0, exit = 0;
        Scanner teclado = new Scanner(System.in);
        initBomb();
        System.out.println("Quantas bombas deseja sortear ? (até 30)");
        numBombs = teclado.nextInt();
        drawBombs(numBombs);
    }
    
    private void initBomb(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                haveBomb[i][j] = false;
            }
        }
    }
    
    public void showBoard(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) { 
                    if(linAtual == i && colAtual == j){
                        System.out.print("P" + "|");
                    }else if(linSaida == i && colSaida == j){
                        System.out.print("S" + "|");
                    }else if(haveBomb[i][j] == true){
                        System.out.print("O" + "|");
                    }else{
                        System.out.print(" " + "|");  
                    }                   
            }
            System.out.println("");
        }
    }
    
    public boolean ehValido(int lin, int col, int qtde, char sentido){
        switch(sentido){
            case 'e':    
                for(int cont = col; cont > colAtual; cont--){
                    if(haveBomb[lin][cont] == true){
                        return true;
                    }else{
                        return false;
                    }
                }
                break;
            case 'c':
               for(int cont = lin; cont > linAtual; cont--){
                    if(haveBomb[cont][col] == true){
                        return true;
                    }else{
                        return false;
                    }
                }
                break;
            case 'd':       
                for(int cont = col; cont < colAtual; cont++){
                    if(haveBomb[lin][cont] == true){
                        return true;
                    }else{
                        return false;
                    }
                }
                break;
            case 'b':
                for(int cont = lin; cont < linAtual; cont++){
                    if(haveBomb[cont][col] == true){
                        return true;
                    }else{
                        return false;
                    }
                }
                break;
            default:
                return false;
        }
        return false;
    }
    
    public boolean exitHere(int lin, int col){
        return lin == linSaida && col == colSaida;
    }
    
    private void drawBombs(int qtde){
        int linha = 0, coluna = 0; 
        do{
            boolean flag = true;
            do{
                linha = random.nextInt(10);
                coluna = random.nextInt(10);
                if(linha == linAtual || linha == linSaida || coluna == colAtual || coluna == colSaida){
                    linha = random.nextInt(10);
                    coluna = random.nextInt(10);
                }else{
                    flag = false;
                }
            }while(flag);
            if(haveBomb[linha][coluna] == true){
                qtde++;
            }else{
                haveBomb[linha][coluna] = true;
            }
            qtde--;
        }while(qtde > 0);
    }
    
}
