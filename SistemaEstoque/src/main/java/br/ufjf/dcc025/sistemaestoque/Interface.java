package br.ufjf.dcc025.sistemaestoque;

import control.RemoverProduto;
import control.SalvarProduto;
import control.TratarLista;
import model.Produtos;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author nelio
 */
public class Interface extends JFrame{
   private JPanel principal;
   private JList<Produtos> lista;
   private JTextField tfNome;
   private JTextField tfValor;
   private JTextField tfQtde;
   private JTextField tfDescricao;
   private int lastIndex;
   
   public Interface(){
       this.lastIndex = 0;
   }
   
   public int getLastIndex(){
       return lastIndex;
   }
   
   public void setLastIndex(int lastIndex){
       this.lastIndex = lastIndex;
   }
   
   public JList<Produtos> getLista(){
       return lista;
   }
   
   public void setLista(JList<Produtos> lista){
       this.lista = lista;
   }
   
   public JTextField getTfNome(){
       return tfNome;
   }
   
   public void setTfNome(JTextField tfNome){
       this.tfNome = tfNome;
   }
   
   public JTextField getTfValor(){
       return tfValor;
   }
   
   public void setTfValor(JTextField tfValor){
       this.tfValor = tfValor;
   }
   
   public JTextField getTfQtde(){
       return tfQtde;
   }
   
   public void setTfQtde(JTextField tfQtde){
       this.tfQtde = tfQtde;
   }
   
   public JTextField getTfDescricao(){
       return tfDescricao;
   }
   
   public void setTfDescricao(JTextField tfDescricao){
       this.tfDescricao = tfDescricao;
   }
   
   private void configuraJanela(){
       this.setSize(500, 300);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       principal = new JPanel();
       principal.setLayout(new BorderLayout());
   }
   
   private void configuraProdutos(){
       JPanel jpProdutos = new JPanel();
       jpProdutos.setBorder(BorderFactory.createTitledBorder("Produtos"));
       jpProdutos.setLayout(new BorderLayout());
       jpProdutos.setPreferredSize(new Dimension(200, 300));
       
       DefaultListModel<Produtos> model = new DefaultListModel<>();
       
       //model.addElement(new Produtos("Pão", 1 , 5, "Salgado"));
       //model.addElement(new Produtos("Leite", 4 , 10, "Itambé"));
       
       lista = new JList<>(model);
       lista.setVisible(true);
       lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       lista.addListSelectionListener(new TratarLista(this));
       jpProdutos.add(new JScrollPane(lista), BorderLayout.WEST);
       
       JPanel botaoPainel = new JPanel();
       botaoPainel.setLayout(new GridLayout(0, 2));
       jpProdutos.add(botaoPainel, BorderLayout.SOUTH);
       
       principal.add(jpProdutos, BorderLayout.EAST);
   }
   
   private void configuraFormulario(){
       JPanel jpFormulario = new JPanel();
       jpFormulario.setBorder(BorderFactory.createTitledBorder("Formulário"));
       
       jpFormulario.add(new JLabel("Nome:"));
       tfNome = new JTextField(20);
       jpFormulario.add(tfNome);
  
       jpFormulario.add(new JLabel("Valor:"));
       tfValor = new JTextField(15);
       jpFormulario.add(tfValor);
       
       jpFormulario.add(new JLabel("Quantidade:"));
       tfQtde = new JTextField(15);
       jpFormulario.add(tfQtde);
       
       jpFormulario.add(new JLabel("Descrição:"));
       tfDescricao = new JTextField(10);
       jpFormulario.add(tfDescricao);
       
       JButton btnAdicionar = new JButton("Adicionar");
       btnAdicionar.addActionListener(new SalvarProduto(this));
       jpFormulario.add(btnAdicionar);
       
       JButton btnRemover = new JButton("Remover");
       btnRemover.addActionListener(new RemoverProduto(this));
       jpFormulario.add(btnRemover);
       
       principal.add(jpFormulario, BorderLayout.CENTER);
   }
   
   public void mostraTela(){
       this.add(principal);
       this.setVisible(true);
   }
   
   public void montaTela(){
       configuraJanela();
       configuraFormulario();
       configuraProdutos();
       mostraTela();
   }
   
    public static void main(String[] args) {
        Interface tela = new Interface();
        tela.montaTela();
    }
}
