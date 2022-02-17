package control;

import br.ufjf.dcc025.sistemaestoque.Interface;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Produtos;

/**
 *
 * @author nelio
 */
public class TratarLista implements ListSelectionListener{

    Interface tela;
    
    public TratarLista(Interface tela){
        this.tela = tela;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = tela.getLista().getSelectedIndex();
        
        if(firstIndex != -1){
            Produtos elementAt = tela.getLista().getModel().getElementAt(firstIndex);
            tela.getTfNome().setText(elementAt.getName());
            tela.getTfValor().setText(Float.toString(elementAt.getValue()));
            tela.getTfQtde().setText(Integer.toString(elementAt.getQty()));
            tela.getTfDescricao().setText(elementAt.getDescription());
            
            tela.setLastIndex(firstIndex);
        }
    }
    
}
