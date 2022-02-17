package br.ufjf.dcc025.financeiro;

/**
 *
 * @author 
 * Nome: Nélio Alves Gouvêa Neto
 * Matrícula: 201935037
 */

public class Data {
    protected int month;
    protected int year;
    
    //default
    public Data(){
        
    }
    
    public Data(int month, int year){
        this.month = month;
        this.year = year;
    }
    
    public void setMonth(int month){
        this.month = month;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getYear(){
        return year;
    }
    
    public int diference(Data date){
        int total_mounths = ((12 * this.year) + this.month) - ((12*date.getYear()) + date.getMonth());
        return total_mounths;
    } 
}
