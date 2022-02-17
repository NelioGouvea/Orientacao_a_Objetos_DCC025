package br.ufjf.dcc025.sistemapagamento;

import java.util.ArrayList;

/**
 *
 * @author nelio
 */
public class Vendedor extends Funcionario{
    private ArrayList<Venda> sale;
    
    //default
    public Vendedor(){
        this.sale = new ArrayList<>();
    }
    
    public Vendedor(String name, double dailySalary){
        super(name, dailySalary);
    }
    
    public Vendedor(String name, double dailySalary, Venda sale){
        super(name, dailySalary);
        this.sale = new ArrayList<>();
    }
    
    public void setSale(Venda sale){
        this.sale.add(sale);
    }
    
    public double getTotalSale(){
        double totalSale = 0;
        for(int i=0; i<sale.size(); i++){
            totalSale += sale.get(i).getTotalValue();
        }
        return totalSale;
    }

    @Override
    public double calculateComission() {
       double totalSales = 0;
       for(int i=0; i<sale.size(); i++){
            totalSales += sale.get(i).getTotalValue();
       }
       return (0.01 * totalSales);
    }

}
