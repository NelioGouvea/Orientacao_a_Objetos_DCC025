package br.ufjf.dcc025.financeiro;
/**
 *
 * @author 
 * Nome: Nélio Alves Gouvêa Neto
 * Matrícula: 201935037
 */

public class RendaFixa extends Investimento{
    
    //default
    public RendaFixa(){
        
    }
    
    public RendaFixa(String title, float value, Data hiring_date){
        super(title, value, hiring_date);
    }

    @Override
    public float calculate_income(Data date) {
        int amount = date.diference(hiring_date);
        float yield = (float) (this.value * 0.005);
        yield = yield * amount;
        return yield;
    }   
}
