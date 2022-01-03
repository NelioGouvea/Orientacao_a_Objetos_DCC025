package br.ufjf.dcc025.jogodavelha;

/**
 *
 * @author nelio
 */
public class Field {
    private char symbol;
    
    public Field(){
        this.symbol = ' ';
    }
    
    public char getSymbol(){
        return this.symbol;
    }
    
    public void setSymbol(char symbol){
        if(this.symbol == ' '){
            this.symbol = symbol;
        }else{
            System.out.print("Campo preenchido");
        }
    }
}
