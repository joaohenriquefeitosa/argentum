/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import main.Negocio;

/**
 *
 * @author joaohenrique
 */
public class ArgentumUI {
    private JFrame janela;
    private JPanel painelPrincipal;
    private JTable tabela;
        
    public static void main(String[] args) {
        new ArgentumUI().montaTela();
    }
    
    public void montaTela(){
        preparaJanela();        
        preparaPainelPrincipal();
        preparaTitulo();
        preparaTabela();        
        preparaBotaoCarregar();
        preparaBotaoSair();
        mostraJanela();
    }    

    private void preparaJanela() {
        janela = new JFrame("Argentum");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void preparaPainelPrincipal() {
        painelPrincipal = new JPanel();
        janela.add(painelPrincipal);
    }

    private void preparaBotaoCarregar() {
        JButton botaoCarregar = new JButton("Carrega XML");
        botaoCarregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Negocio> lista = new EscolhedorDeXML().escolhe();
                NegociosTableModel ntm = new NegociosTableModel(lista);
                tabela.setModel(ntm);
            }
        });
        botaoCarregar.setMnemonic(KeyEvent.VK_C);
        painelPrincipal.add(botaoCarregar);
    }

    private void preparaBotaoSair() {
        JButton botaoSair = new JButton("Sair");
        botaoSair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        botaoSair.setMnemonic(KeyEvent.VK_S);
        painelPrincipal.add(botaoSair);
    }

    private void mostraJanela() {
        janela.pack();
        janela.setSize(540, 540);
        janela.setVisible(true);
    }

    private void preparaTabela() {
        tabela = new JTable();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(tabela);
        
        painelPrincipal.add(scroll);        
    }

    private void preparaTitulo() {
        JLabel titulo = new JLabel("Lista de Negócios", SwingConstants.CENTER);
        titulo.setFont(new Font("Verdana", Font.BOLD, 25));
        painelPrincipal.add(titulo);
    }
}
