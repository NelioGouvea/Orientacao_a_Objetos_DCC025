package br.ufjf.dcc025.jogodavelha;

import java.util.Scanner;
/**
 *
 * @author nelio
 */
public class JogoDaVelha {
    
    public static void main(String[] args) {
        Field [][] matriz = new Field[3][3];
        char currentSymbol = 'X';
        boolean activeGame = true;   
        String victory ="";
        Scanner teclado =  new Scanner(System.in);
        
        startGame(matriz);
        while(activeGame){
            drawGame(matriz);
            victory = verifyVictory(matriz, currentSymbol);
            if(victory.equals("Empate")){
                 System.out.println("Temos um empate! ");
                break;
            }else if(!victory.equals("")){
                System.out.printf("Jogador %s venceu! \n", victory);
                break;
            }else{
                try{
                    if(checkPlay(matriz, Play(teclado, currentSymbol), currentSymbol)){
                        if(currentSymbol == 'X'){
                            currentSymbol = 'O';
                        }else{
                            currentSymbol = 'X';
                        }
                    }
                }catch(Exception e){
                    System.out.println("Erro. Digite valores corretos!");
                }
            }
        }
        System.out.println("******** FIM DO JOGO ********");
    }
    
    public static void drawGame(Field[][] game){
        System.out.println("   1   2   3");
        System.out.printf ("1  %c | %c | %c \n", game[0][0].getSymbol(), game[0][1].getSymbol(), game[0][2].getSymbol());
        System.out.println("----------------");
        System.out.printf ("2  %c | %c | %c \n", game[1][0].getSymbol(), game[1][1].getSymbol(), game[1][2].getSymbol());
        System.out.println("----------------");
        System.out.printf ("3  %c | %c | %c \n", game[2][0].getSymbol(), game[2][1].getSymbol(), game[2][2].getSymbol());
    }
    
    public static String verifyVictory(Field[][] game, char currentSymbol){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if((game[0][0].getSymbol() == 'X' && game[1][0].getSymbol() == 'X' && game[2][0].getSymbol() == 'X') ||
                   (game[0][1].getSymbol() == 'X' && game[1][1].getSymbol() == 'X' && game[2][1].getSymbol() == 'X') ||
                   (game[0][2].getSymbol() == 'X' && game[1][2].getSymbol() == 'X' && game[2][2].getSymbol() == 'X') ||
                   (game[0][0].getSymbol() == 'X' && game[0][1].getSymbol() == 'X' && game[0][2].getSymbol() == 'X') ||
                   (game[1][0].getSymbol() == 'X' && game[1][1].getSymbol() == 'X' && game[1][2].getSymbol() == 'X') ||
                   (game[2][0].getSymbol() == 'X' && game[2][1].getSymbol() == 'X' && game[2][2].getSymbol() == 'X') ||
                   (game[0][0].getSymbol() == 'X' && game[1][1].getSymbol() == 'X' && game[2][2].getSymbol() == 'X') ||
                   (game[0][2].getSymbol() == 'X' && game[1][1].getSymbol() == 'X' && game[2][0].getSymbol() == 'X')){
                    return "X";
                }
                if((game[0][0].getSymbol() == 'O' && game[1][0].getSymbol() == 'O' && game[2][0].getSymbol() == 'O') ||
                        (game[0][1].getSymbol() == 'O' && game[1][1].getSymbol() == 'O' && game[2][1].getSymbol() == 'O') ||
                        (game[0][2].getSymbol() == 'O' && game[1][2].getSymbol() == 'O' && game[2][2].getSymbol() == 'O') ||
                        (game[0][0].getSymbol() == 'O' && game[0][1].getSymbol() == 'O' && game[0][2].getSymbol() == 'O') ||
                        (game[1][0].getSymbol() == 'O' && game[1][1].getSymbol() == 'O' && game[1][2].getSymbol() == 'O') ||
                        (game[2][0].getSymbol() == 'O' && game[2][1].getSymbol() == 'O' && game[2][2].getSymbol() == 'O') ||
                        (game[0][0].getSymbol() == 'O' && game[1][1].getSymbol() == 'O' && game[2][2].getSymbol() == 'O') ||
                        (game[0][2].getSymbol() == 'O' && game[1][1].getSymbol() == 'O' && game[2][0].getSymbol() == 'O')){
                        return "O";
                }
                if((game[0][0].getSymbol() == 'X' || game[0][0].getSymbol() == 'O') && (game[0][1].getSymbol() == 'X' || game[0][1].getSymbol() == 'O') &&
                   (game[0][2].getSymbol() == 'X' || game[0][2].getSymbol() == 'O') && (game[1][0].getSymbol() == 'X' || game[1][0].getSymbol() == 'O') &&
                   (game[1][1].getSymbol() == 'X' || game[1][1].getSymbol() == 'O') && (game[1][2].getSymbol() == 'X' || game[1][2].getSymbol() == 'O') &&
                   (game[2][0].getSymbol() == 'X' || game[2][0].getSymbol() == 'O') && (game[2][1].getSymbol() == 'X' || game[2][1].getSymbol() == 'O') &&
                   (game[2][2].getSymbol() == 'X' || game[2][2].getSymbol() == 'O')){
                   return "Empate";
                }
            }
        }
        return "";
    }
    
    public static int[] Play(Scanner teclado, char currentSymbol){
        int p[] = new int[2];
        System.out.printf("%s %c\n", "Quem joga: ", currentSymbol);
        System.out.println("Digite a linha da jogada: (1 a 3)");
        p[0] = teclado.nextInt() - 1;
        System.out.println("Digite a coluna da jogada: (1 a 3)");
        p[1] = teclado.nextInt() - 1;
        return p;
    }
    
    public static boolean checkPlay(Field[][] game,int point[], char currentSymbol){
        if(game[point[0]][point[1]].getSymbol() == ' '){
            game[point[0]][point[1]].setSymbol(currentSymbol);
            return true;
        }else{
            return false;
        }
    }
    
    public static void startGame(Field[][] game){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                game[i][j] = new Field();
            }
        }
    }
}
