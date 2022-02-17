/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import br.ufjf.dcc025.sistemaestoque.Interface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import model.Produtos;

/**
 *
 * @author nelio
 */
public class RemoverProduto implements ActionListener{
    private Interface tela;
    
    public RemoverProduto(Interface tela){
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex = tela.getLista().getSelectedIndex();
        if(selectedIndex != -1){
            DefaultListModel<Produtos> model = (DefaultListModel<Produtos>) tela.getLista().getModel();
            model.removeElementAt(selectedIndex);
            tela.getLista().setModel(model);
        }
    }
}
