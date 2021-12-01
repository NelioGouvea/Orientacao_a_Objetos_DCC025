package br.ufjf.dcc025.sudoku;

import java.util.Scanner;

/**
 *
 * @author nelio
 */
public class Sudoku {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
       
        int linha = -1, coluna = -1, numero = -1;   //inicializando variaveis com valores invalidos
        boolean validar = true; //validar numeros digitados
        
        int[][] matriz = new int[9][9]; //matriz usada para o jogo
        boolean [][] fixo = new boolean[9][9]; //posicoes fixas nao alteraveis
        int option = 0; //variavel que receberá escolha do jogador
        
        System.out.println("******************************");
        System.out.println("*     BEM VINDO AO SUDOKU    *");
        System.out.println("******************************");
        
        //Escolhe inicializacao do jogo
        do{
            System.out.println("Digite 1 para gerar um jogo aleatório "
                + "ou 2 para definir seu próprio jogo: ");
            option = teclado.nextInt();
            if(option <1 || option >2){
                System.out.println("Opção inválida!");
            }else{
                validar = false;
            }
        }while(validar);
        validar = true; //inicializando para usar novamente
        
        //Inicializa a matriz de acordo com o escolhido
        if(option == 1){
            do{
                System.out.println("Quantos numeros deseja sortear ? (ate 24)");
                option = teclado.nextInt();
                if(option < 0 || option > 24){
                    System.out.println("Valor inválido");
                }else{
                    validar = false;
                }
                
            }while(validar);
            
        }
        
        fixo = ehPreenchido(fixo, matriz);
    }
    
    private static boolean[][] ehPreenchido(boolean[][] fixo, int[][] matriz){
        for (int i=0; i < matriz.length; i++){
            for (int j=0; j< matriz[0].length; j++){
                if (matriz[i][j] != 0)
                    fixo[i][j] = true;
            }
        }
        return fixo;
    }
}