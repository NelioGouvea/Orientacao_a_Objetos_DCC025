package br.ufjf.dcc025.financeiro;

/**
 *
 * @author 
 * Nome: Nélio Alves Gouvêa Neto
 * Matrícula: 201935037
 */

abstract class Investimento implements Rendimento{
    protected String title;
    protected float value;
    protected Data hiring_date;
    
    //default
    protected Investimento(){
        
    }
    
    public Investimento(String title, float value, Data hiring_date){
        this.title = title;
        this.value = value;
        this.hiring_date = hiring_date;
    }
    
    protected void setTitle(String title){
        this.title = title;
    }
    
    protected void setValue(float value){
        this.value = value;
    }
    
    protected void setHiringDate(Data hiring_date){
        this.hiring_date = hiring_date;
    }
    
    protected String getTitle(){
        return title;
    }
    
    protected float getValue(){
        return value;
    }
    
    protected Data getHiringDate(){
        return hiring_date;
    }
}
