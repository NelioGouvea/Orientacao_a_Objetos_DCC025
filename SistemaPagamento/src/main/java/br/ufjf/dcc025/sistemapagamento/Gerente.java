package br.ufjf.dcc025.sistemapagamento;

import java.util.ArrayList;

/**
 *
 * @author nelio
 */
public class Gerente extends Funcionario{
    private ArrayList<Vendedor> seller;
    
    //default
    public Gerente(){
        this.seller = new ArrayList<>();
    }
    
    public Gerente(String name, double dailySalary, Vendedor seller){
        super(name, dailySalary);
        this.seller = new ArrayList<>();
    }
 
    public void setSeller(Vendedor seller){
        this.seller.add(seller);
    }
    
    public Vendedor getSeller(String name){
        for(int i=0; i<seller.size(); i++){
            if((seller.get(i).name).equals(name)){
                return seller.get(i);
            }
        }
        return null;
    }

    @Override 
    public double calculateComission() {
        double totalSales = 0;
        for(int i=0; i<seller.size(); i++){
            totalSales = seller.get(i).getTotalSale();
        }
        return (0.0005 * totalSales);
    }

}
