package br.ufjf.dcc025.sudoku;

import java.util.Scanner; //classe para ler valores do teclado
import java.util.Random; //classe para gerar valores aleatorios


/**
 *
 * @author nelio
 */
public class Sudoku {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
       
        int linha = -1, coluna = -1, numero = -1, sorteio = -1; 
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
        fixo = ehPreenchido(fixo, matriz); //inicializa todas posicoes da matriz como válida
        
        //Inicializa a matriz de acordo com o escolhido
        if(option == 1){
            do{
                System.out.println("Quantos numeros deseja sortear ? (ate 24)");
                sorteio = teclado.nextInt();
                if(sorteio < 0 || sorteio > 24){
                    System.out.println("Valor inválido");
                }else{
                    validar = false;
                }     
            }while(validar);
            
            Random gerador = new Random();
            for(int i=0; i < sorteio; i++){
                //inserindo um valor aleatorio em uma posição aleatória
                linha = gerador.nextInt(9);
                coluna = gerador.nextInt(9);
                numero = gerador.nextInt(9) + 1;
                if(ehPossivelInserir(matriz, linha, coluna, numero)){
                    matriz[linha][coluna] = numero;
                }else{
                    i--;
                }
            }
        }else{
            do{
                //solicita entrada dos valores para o tabuleiro e inicia o jogo caso digitado 0
                System.out.println("Informe números de 1 a 9 para linha, coluna e numero a ser fixado no tabuleiro.");
                System.out.println("Quando terminar de definir o tabuleiro digite 0!");
                System.out.println("Linha > ");
                linha = teclado.nextInt();
                if(linha == 0){
                    validar = false;
                }
                linha -= linha;

                System.out.println("Coluna > ");
                coluna = teclado.nextInt();
                if(coluna == 0){
                    validar = false;
                }
                coluna -= coluna;

                System.out.println("Número > ");
                numero = teclado.nextInt();
                if(numero == 0){
                    validar = false;
                }
                numero -= numero;
                
                if(linha < 0 || linha > 8 || coluna < 0 || coluna > 8 || numero < 1 || numero > 9){
                    System.out.println("Somente números de 1 a 9 são válidos!");
                }else{
                    matriz[linha][coluna] = numero;
                }
            }while(validar);      
        }
        ehPreenchido(fixo, matriz);//atualiza as posicoes válidas da matriz inicial
        
        System.out.println("*************************");
        System.out.println("***** JOGO INCIADO: *****");
        System.out.println("*************************");
        
        imprimeMatriz(matriz);
        
        
        
    }
    
    //define posicoes válidas para inserção de valores
    private static boolean[][] ehPreenchido(boolean[][] fixo, int[][] matriz){
        for (int i=0; i < matriz.length; i++){
            for (int j=0; j< matriz[0].length; j++){
                if (matriz[i][j] != 0)
                    fixo[i][j] = true;
            }
        }
        return fixo;
    }
    
    //verifica se pode ser inserido valor em x posicao
    public static boolean ehPossivelInserir(int[][]matriz, int linha, int coluna, int numero){
        //verifica a linha toda em busca do valor
        for (int i=0; i< matriz[0].length; i++){
            if(matriz[linha][i] == numero){
                return false;
            }
        }
        //verifica a coluna toda em busca do valor
        for(int i=0; i< matriz.length; i++){
            if(matriz[i][coluna] == numero){
                return false;
            }
        } 
        //verifica o quadrado 3x3
        int quadLinha = linha - linha % 3;
        int quadColuna = coluna - coluna % 3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(matriz[quadLinha + i][quadColuna + j] == numero);
            }
        }
        //após verificar tudo
        return true;
    }
    
    //imprime matriz
    public static void imprimeMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++)  {  
            for (int j = 0; j < matriz[0].length; j++){ 
                System.out.print(matriz[i][j] + " "); //imprime caracter a caracter
            }  
        System.out.println(" "); //muda de linha
        }  
    }
}