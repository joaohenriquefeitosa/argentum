/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import grafico.GeradorDeGrafico;
import indicadores.GeradorDeSerie;
import indicadores.IndicadorFechamento;
import indicadores.MediaMovelSimples;
import indicadores.SerieTemporal;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author joaohenrique
 */
public class TestaGrafico {
    public static void main(String[] args) throws IOException{
        SerieTemporal serie = GeradorDeSerie.criaSerie(1,2,3,4,5,6,7,
                                                       8,8,9,9,4,3,2,1,2,2,4,5,6,7,
                                                       8,9,10,11,10,6,3,2,6,7,8,9);
        GeradorDeGrafico g = new GeradorDeGrafico(serie, 3, 32);
        g.plotaIndicador(new MediaMovelSimples());
        g.plotaIndicador(new IndicadorFechamento());
        g.salva(new FileOutputStream("grafico.png"));
        
        JFrame frame = new JFrame("Minha Janela");
        frame.add(g.getPanel());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
