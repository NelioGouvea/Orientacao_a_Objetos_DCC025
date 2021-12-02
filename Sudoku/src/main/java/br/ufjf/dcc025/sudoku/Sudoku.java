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
        matriz = inicializaMatriz(matriz); // inicializa matriz 
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
        fixo = ehPreenchido(fixo, matriz); //inicializa todas posicoes da matriz como válidas
        
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

                if(fixo[linha][coluna]){
                    i--;
                }else{
                    if(ehPossivelInserir(matriz, linha, coluna, numero)){
                        matriz[linha][coluna] = numero;
                        fixo[linha][coluna] = true;
                    }else{
                        i--;
                    }
                }
            }
        }else{
            //solicita entrada dos valores para o tabuleiro e inicia o jogo caso digitado 0
            System.out.println("Informe números de 1 a 9 para linha, coluna e numero a ser fixado no tabuleiro :) ");
            System.out.println("Quando terminar de definir o tabuleiro digite 0! ");
            do{
                System.out.println("Linha: ");
                linha = teclado.nextInt();
                if(linha == 0){
                    break;
                }
                linha = linha - 1;

                System.out.println("Coluna: ");
                coluna = teclado.nextInt();
                if(coluna == 0){
                    break;
                }
                coluna = coluna - 1;

                System.out.println("Número: ");
                numero = teclado.nextInt();
                if(numero == 0){
                    break;
                }
                
                if(linha < 0 || linha > 8 || coluna < 0 || coluna > 8 || numero < 1 || numero > 9){
                    System.out.println("Somente números de 1 a 9 são válidos! ");
                }else{
                    if(ehPossivelInserir(matriz, linha, coluna, numero)){
                        matriz[linha][coluna] = numero;
                    }else{
                        System.out.println("Já existe o numero " + 8 + " nessa coluna ou linha");
                    }
                    
                }
            }while(validar);      
        }
        ehPreenchido(fixo, matriz);//atualiza as posicoes válidas da matriz inicial
        
        System.out.println("*************************");
        System.out.println("***** JOGO INCIADO: *****");
        System.out.println("*************************");
        
        do{
            validar = true; //atualizando para usar novamente
            System.out.println("");
            imprimeMatriz(matriz);
            
            boolean flag = true;
            do{
                System.out.println("Digite 1 para inserir um número, 2 para remover um número, 3 para avaliar se o jogo esta correto e 4 para sair: ");
                option = teclado.nextInt();
                
                 switch(option){
                    case 1: //Inserção
                        System.out.println("Informe números de 1 a 9 para linha, coluna e numero a ser inserido no tabuleiro :) ");
                        do{
                            System.out.println("Linha: ");
                            linha = teclado.nextInt();
                            linha = linha - 1;

                            System.out.println("Coluna: ");
                            coluna = teclado.nextInt();
                            coluna = coluna - 1;

                            System.out.println("Número: ");
                            numero = teclado.nextInt();

                            if(linha<0 || linha>8 || coluna<0 || coluna> 8 || numero<1 || numero>9){
                                System.out.println("Somente numeros de 1 a 9 são válidos! ");
                            }else{
                                validar = false;
                            }
                        }while(validar);
                        validar = true; //atualizando para usar novamente

                        if(fixo[linha][coluna]){
                            System.out.println("Essas posições foram fixadas no inicio do jogo, você não pode alterá-las! ");
                        }else{
                            if(ehPossivelInserir(matriz, linha, coluna, numero)){
                                matriz[linha][coluna] = numero;
                            }else{
                                System.out.println("Movimento Inválido! ");
                            }
                        }
                        flag = false;
                        break;
                    case 2: //Remoção
                    System.out.println("Informe números de 1 a 9 para linha, coluna e numero a ser inserido no tabuleiro :) ");
                        do{
                            System.out.println("Linha: ");
                            linha = teclado.nextInt();
                            linha = linha - 1;

                            System.out.println("Coluna: ");
                            coluna = teclado.nextInt();
                            coluna = coluna - 1;

                            if(linha<0 || linha>8 || coluna<0 || coluna> 8 ){
                                System.out.println("Somente linhas e colunas de 1 a 9 são válidas! ");
                            }else{
                                validar = false;
                            }
                        }while(validar);
                        validar = true; //atualizando para usar novamente
                        if(fixo[linha][coluna]){
                            System.out.println("Essas posições foram fixadas no inicio do jogo, você não pode alterá-las! ");
                        }else{
                            matriz[linha][coluna] = 0;
                        }  
                        flag = false;
                        break;
                    case 3: //Validar
                        if(tabuleiroCompleto(matriz)){
                            System.out.println("******************************************************");
                            System.out.println("***** PRABENS VOCE CONSEGUIU, OBRIGADO POR JOGAR *****");
                            System.out.println("******************************************************");
                            flag=false;
                            validar = false;
                        }else{
                            System.out.println("O Jogo ainda não está completo :( ");
                        }
                        break;
                    case 4: //Sair
                        System.out.println("Jogo encerrado!");
                        flag = false;
                        validar = false;
                        break;
                    default:
                        System.out.println("Digite um valor válido!!!");
                }
            }while(flag); 
        }while(validar);        
    }
    
    //define posicoes válidas para inserção de valores
    private static boolean[][] ehPreenchido(boolean[][] fixo, int[][] matriz){
        for (int i=0; i < matriz.length; i++){
            for (int j=0; j< matriz[0].length; j++){
                if (matriz[i][j] != 0){
                    fixo[i][j] = true;
                }else{
                    fixo[i][j] = false;
                }                
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
                if(matriz[quadLinha + i][quadColuna + j] == numero){
                    return false;
                }
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
    
    //verifica se o tabuleiro esta todo preeenchido
    public static boolean tabuleiroCompleto(int[][] matriz){
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[0].length; j++){
                if(matriz[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    
    //inicializa matriz com zeros(posicoes em branco)
    public static int[][] inicializaMatriz(int[][] matriz){
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[0].length; j++){
                matriz[i][j] = 0;
            }
        }
        return matriz;
    }
}