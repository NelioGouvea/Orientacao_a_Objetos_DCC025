package br.ufjf.dcc025.sistemapagamento;

/**
 *
 * @author nelio
 */
public class Venda {
    private double totalValue;
    
    //default
    public Venda(){
        totalValue = 0;
    }
    
    public Venda(double totalValue){
        this.totalValue = totalValue;
    }
    
    public void setTotalValue(double value){
        this.totalValue = value;
    }
    
    public double getTotalValue(){
        return totalValue;
    }
}
