package control;

import br.ufjf.dcc025.sistemaestoque.Interface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Produtos;

/**
 *
 * @author nelio
 */
public class SalvarProduto implements ActionListener{
    Interface tela;
    
    public SalvarProduto(Interface tela){
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel<Produtos> model = (DefaultListModel<Produtos>) tela.getLista().getModel();
        
        if(tela.getTfNome().getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Nome está vázio");
        }else if(tela.getTfValor().getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Valor está vázio");
        }else if(tela.getTfQtde().getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Quantidade está vázio");
        }else if(tela.getTfDescricao().getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Descricao está vázio");
        }else{
            model.addElement(
                new Produtos(
                        tela.getTfNome().getText(),
                        Float.parseFloat(tela.getTfValor().getText()),
                        Integer.parseInt(tela.getTfQtde().getText()),
                        tela.getTfDescricao().getText()));
        }
        
        
        
        tela.getLista().setModel(model);
        tela.repaint();
    }  
}
