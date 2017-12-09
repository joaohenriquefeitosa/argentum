/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import grafico.GeradorDeGrafico;
import indicadores.IndicadorFechamento;
import indicadores.MediaMovelSimples;
import indicadores.SerieTemporal;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import main.Candle;
import main.Negocio;
import reader.CandlestickFactory;

/**
 *
 * @author joaohenrique
 */
public class ArgentumUI {
    private JFrame janela;
    private JPanel painelPrincipal;
    private JTable tabela;
    private JPanel painelBotoes;
    private JTabbedPane abas;
        
    public static void main(String[] args) {
        new ArgentumUI().montaTela();
    }
    
    public void montaTela(){
        preparaJanela();        
        preparaPainelPrincipal();
        preparaAbas();
        preparaTitulo();
        preparaTabela();        
        preparaPainelBotoes();
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
        painelPrincipal.setLayout(new BorderLayout());
        janela.add(painelPrincipal);
    }

    private void preparaBotaoCarregar() {
        JButton botaoCarregar = new JButton("Carrega XML");
        botaoCarregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                carregaDados();
            }

            private void carregaDados() {
                List<Negocio> lista = new EscolhedorDeXML().escolhe();
                NegociosTableModel ntm = new NegociosTableModel(lista);
                tabela.setModel(ntm);
                
                CandlestickFactory fabrica = new CandlestickFactory();
                List<Candle> candles = fabrica.constroiCandles(lista);
                SerieTemporal serie = new SerieTemporal(candles);
                
                GeradorDeGrafico gerador = new GeradorDeGrafico(serie, 2, serie.getTotal() - 1);
                gerador.plotaIndicador(new MediaMovelSimples());
                gerador.plotaIndicador(new IndicadorFechamento());
                
                abas.setComponentAt(1, gerador.getPanel());
            }
        });
        botaoCarregar.setMnemonic(KeyEvent.VK_C);
        painelBotoes.add(botaoCarregar);
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
        painelBotoes.add(botaoSair);
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
        abas.setComponentAt(0, scroll);
    }

    private void preparaTitulo() {
        JLabel titulo = new JLabel("Lista de Negócios", SwingConstants.CENTER);
        titulo.setFont(new Font("Verdana", Font.BOLD, 25));
        painelPrincipal.add(titulo, BorderLayout.NORTH);
    }

    private void preparaPainelBotoes() {
        painelBotoes = new JPanel(new GridLayout());
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
    }
    
    private void preparaAbas(){
        abas = new JTabbedPane();
        abas.addTab("Tabela", null);
        abas.addTab("Gráfico", null);
        painelPrincipal.add(abas);
    }
}
