package br.ufjf.dcc025.bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {

    private int cartela[][] = new int[5][5];
    private boolean marcada[][] = new boolean[5][5];
    private static List<Integer> drawnNumbers = new ArrayList<>();

    Card() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int valor = 0;
                if (i == 2 && j == 2) {
                    cartela[i][j] = 0;
                    marcada[i][j] = true;
                } else if (j == 0) {
                    do {
                        valor = random.nextInt(15) + 1;
                    } while (!ehValido(i, j, valor));
                    cartela[i][j] = valor;
                } else if (j == 1) {
                    do {
                        valor = random.nextInt(15) + 16;
                    } while (!ehValido(i, j, valor));
                    cartela[i][j] = valor;
                } else if (j == 2) {
                    do {
                        valor = random.nextInt(15) + 31;
                    } while (!ehValido(i, j, valor));
                    cartela[i][j] = valor;
                } else if (j == 3) {
                    do {
                        valor = random.nextInt(15) + 46;
                    } while (!ehValido(i, j, valor));
                    cartela[i][j] = valor;
                } else if (j == 4) {
                    do {
                        valor = random.nextInt(15) + 61;
                    } while (!ehValido(i, j, valor));
                    cartela[i][j] = valor;
                }
            }
        }
    }

    public void showCard() {
        System.out.println(" B  | I  | N  | G  | O ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (cartela[i][j] == 0 || (i == 2 && j == 2)) {
                    System.out.print(" ** |");
                } else if (!marcada[i][j]) {
                    System.out.print(" " + cartela[i][j] + " " + "|");
                } else {
                    System.out.print("*" + cartela[i][j] + "*" + "|");
                }
            }
            System.out.println("");
        }
    }

    private boolean ehValido(int linha, int coluna, int value) {
        for (int i = 0; i < linha; i++) {
            if (cartela[i][coluna] == value) {
                return false;
            }
        }
        return true;
    }

    public boolean checkBingo() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!marcada[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int drawNumber() {
        int n = 0;
        do {
            n = (int) new Random().nextInt(74) + 1;
        } while (drawnNumbers.contains(n));
        drawnNumbers.add(n);
        return n;
    }

    public void markNumber(int number, int cardIndex) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (cartela[i][j] == number) {
                    marcada[i][j] = true;
                    System.out.println("A cartela " + (cardIndex + 1) + " teve o número " + cartela[i][j] + " marcado!");
                    return;
                }
            }
        }
    }

}
