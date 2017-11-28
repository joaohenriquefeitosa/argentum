/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author joaohenrique
 */
public class ArgentumUI {
    private JFrame janela;
    private JPanel painelPrincipal;
        
    public static void main(String[] args) {
        new ArgentumUI().montaTela();
    }
    
    public void montaTela(){
        preparaJanela();
        preparaPainelPrincipal();
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
                new EscolhedorDeXML().escolhe();
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
}
