package model;

/**
 *
 * @author nelio
 */
public class Produtos {
    protected String name;
    protected float value;
    protected int qty;
    protected String description;
    
    //default
    Produtos(){
        
    }
    
    public Produtos(String name, float value, int qty, String description){
        this.name = name;
        this.value = value;
        this.qty = qty;
        this.description = description;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setValue(float value){
        this.value = value;
    }
    
    public void setQty(int qty){
        this.qty = qty;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getName(){
        return name;
    }
    
    public float getValue(){
        return value;
    }
    
    
    public int getQty(){
        return qty;
    }
    
    public String getDescription(){
        return description;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
}
