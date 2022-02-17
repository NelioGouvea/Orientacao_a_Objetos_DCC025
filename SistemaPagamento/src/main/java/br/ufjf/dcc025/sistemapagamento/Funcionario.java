package br.ufjf.dcc025.sistemapagamento;

/**
 *
 * @author nelio
 */
abstract class Funcionario {
    public String name;
    public double dailySalary;
    
    //default
    public Funcionario(){
        
    }
    
    public Funcionario(String name, double dailySalary){
        this.name = name;
        this.dailySalary = dailySalary;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setDailySalary(double value){
        this.dailySalary = value;
    }
    
    public double getDailySalary(){
        return dailySalary;
    }
    
    public abstract double calculateComission();
    
}
