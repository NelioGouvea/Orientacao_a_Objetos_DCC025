package br.ufjf.dcc025.financeiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 
 * Nome: Nélio Alves Gouvêa Neto
 * Matrícula: 201935037
 */

public class Simulacao {
    static List<Investimento> investments = new ArrayList<>();
    static Data date = new Data();
    static Scanner leitura = new Scanner(System.in);

    static Scanner leituraString = new Scanner(System.in);
    static Scanner leituraInt = new Scanner(System.in);
    static String month = "";
    static String year = "";
    
    
    
    public static void main(String[] args) {
        Data date = new Data();
        for(int i=1; i<4; i++){
            RendaFixa renda_fixa = new RendaFixa();
            date = new Data();
            System.out.println("Lendo valores do " + i + "o investimento de renda fixa. Os seguintes dados: ");
             Scanner leituraString = new Scanner(System.in);
            System.out.println("Digite o titulo do investimento: ");
            renda_fixa.setTitle(leitura.nextLine());
            System.out.println("Digite o valor do investimento: ");
            renda_fixa.setValue(leituraString.nextFloat());
            System.out.println("Digite o mes do invesimento: ");
            date.setMonth(leituraInt.nextInt());
            Scanner teclado = new Scanner(System.in);
            System.out.println("Digite o ano do investimento: ");   
            date.setYear(teclado.nextInt());
            renda_fixa.setHiringDate(date);
            investments.add(renda_fixa);           
        }
        
        for(int i=1; i<3; i++){
            RendaVariavel renda_variavel = new RendaVariavel();
            date = new Data();
            leituraString = new Scanner(System.in);
            System.out.println("Lendo valores do " + i + "o investimento de renda variavel. Os seguintes dados: ");
            System.out.println("Digite o titulo do investimento: ");
            renda_variavel.setTitle(leituraString.nextLine());
            System.out.println("Digite o valor do investimento: ");
            renda_variavel.setValue(leitura.nextFloat());
            System.out.println("Digite o mes do invesimento: ");
            date.setMonth(leituraInt.nextInt());
            Scanner teclado = new Scanner(System.in);
            System.out.println("Digite o ano do investimento: ");
            date.setYear(teclado.nextInt());
            renda_variavel.setHiringDate(date);
            investments.add(renda_variavel);
        }
        
        System.out.println("Digite agora a data final de simulacao: ");
        System.out.println("Mês: ");
        date.setMonth(leitura.nextInt());
        System.out.println("Ano: ");
        Scanner teclado = new Scanner(System.in);
        date.setYear(teclado.nextInt());
        accrued_income(date);
        
    }
    
    static void accrued_income(Data date){
        //imprimir os dados de cada investimento pra essa data e imprime o rendimento total do mes??
        for(int i=0; i<investments.size(); i++){
            System.out.println("Titulo do investimento: " + investments.get(i).getTitle());
            System.out.println("Valor investido: " + investments.get(i).getTitle());
            System.out.println("Data de contratação: " + investments.get(i).getHiringDate().getMonth() + "/" + investments.get(i).getHiringDate().getYear());
            System.out.println("Rendimento acumulado: " + investments.get(i).calculate_income(date));
        }
    }
}
