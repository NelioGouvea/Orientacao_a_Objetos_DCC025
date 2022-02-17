package br.ufjf.dcc025.financeiro;

/**
 *
 * @author 
 * Nome: Nélio Alves Gouvêa Neto
 * Matrícula: 201935037
 */

public class RendaVariavel extends Investimento{
    
//default
    public RendaVariavel(){
        
    }
    
    public RendaVariavel(String title, float value, Data hiring_date){
        super(title, value, hiring_date);
    }

    @Override
    public float calculate_income(Data date) {
        int amount = date.diference(hiring_date);
        float total_yield = this.value ;
        for(int i=0; i<amount; i++){
            total_yield += (total_yield * 0.008);
        }
        return (total_yield - this.value);
    }
}
