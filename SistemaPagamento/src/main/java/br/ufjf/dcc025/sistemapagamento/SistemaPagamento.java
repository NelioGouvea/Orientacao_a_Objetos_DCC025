package br.ufjf.dcc025.sistemapagamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nelio
 */
public class SistemaPagamento {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Scanner leitura = new Scanner(System.in);
        String vendedor, gerente;
        double value;
        boolean correto = true;
        List<Funcionario> employees = new ArrayList<>();
        List<Vendedor> sellers = new ArrayList<>();
        List<Gerente> managers = new ArrayList<>();
        
        int option = 0;
        
        System.out.println("*******************************************");
        System.out.println("*****BEM VINDO AO SISTEMA DE PAGAMENTO*****");
        System.out.println("*******************************************");
                
        do{
            System.out.println("****************************************************************************");
            System.out.println("Selecione a opção que deseja abaixo(favor informar o numero correspondente): ");
            System.out.println("1. Cadastrar Vendedor");
            System.out.println("2. Cadastrar Gerente");
            System.out.println("3. Associar um Vendedor a um Gerente");
            System.out.println("4. Registrar as vendas realizadas por um vendedor");
            System.out.println("5. Calcular o valor que será pago a cada funcionário no final do dia");
            System.out.println("6. Sair");
            option = teclado.nextInt();
            
            switch(option){
                case 1: 
                    Vendedor seller = new Vendedor();
                    System.out.println("Digite o nome do Vendedor: ");
                    vendedor = leitura.nextLine();
                    seller.setName(vendedor);
                    System.out.println("Digite o salário diário fixo do " + vendedor + " :");
                    value = teclado.nextDouble();
                    seller.setDailySalary(value);
                    employees.add(seller);    
                    sellers.add(seller);
                    break;
                case 2:
                    Gerente manager = new Gerente();
                    System.out.println("Digite o nome do Gerente: ");
                    gerente = leitura.nextLine();
                    System.out.println("Digite o salário diário fixo do " + gerente + " :");
                    value = teclado.nextDouble();
                    manager.setName(gerente);
                    manager.setDailySalary(value);
                    employees.add(manager);
                    managers.add(manager);
                    break;
                case 3:
                    System.out.println("Digite o nome do Vendedor que irá associar a um Gerente: ");
                    vendedor = leitura.nextLine();
                    System.out.println("Digite o nome do Gerente a qual o " + vendedor + " será assossiado: ");
                    gerente = leitura.nextLine();
                    for(int i=0; i<sellers.size(); i++){
                        if(vendedor.equals(sellers.get(i).getName())){
                            for(int j=0; j<managers.size(); j++){
                                if(gerente.equals(managers.get(j).getName())){
                                    managers.get(j).setSeller(sellers.get(i));
                                }
                            }
                        }
                    }
                    break;
                case 4: 
                    Venda sale = new Venda();
                    System.out.println("Digite o nome do vendedor que fez a venda: ");
                    vendedor = leitura.nextLine();
                    System.out.println("Digite o valor total da venda: ");
                    sale.setTotalValue(teclado.nextDouble());
                    for(int i=0; i<sellers.size(); i++){
                        if(vendedor.equals(sellers.get(i).getName())){
                            sellers.get(i).setSale(sale);
                        }
                    }
                    break;
                case 5: 
                    System.out.println("****************************************************************************");
                    System.out.println("Lista de Pagamentos: ");
                    for(int i=0; i<employees.size(); i++){
                        System.out.println("" + employees.get(i).getName() + " : R$" + (employees.get(i).calculateComission() + employees.get(i).dailySalary));
                    }
                    System.out.println("****************************************************************************");
                    break;
                case 6: 
                    option = 6;
                    break;
                default:
                    System.out.println("Por favor digite um valor válido!!");
            }
                    
        }while(option != 6);
        
        
    }
}
