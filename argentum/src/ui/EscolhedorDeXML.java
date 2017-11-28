/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import main.Negocio;
import reader.LeitorXML;

/**
 *
 * @author joaohenrique
 */
public class EscolhedorDeXML {
    
    public static void main(String[] args) {
        new EscolhedorDeXML().escolhe();
    }
    
    public void escolhe(){
        try{
        JFileChooser chooser = new JFileChooser("/home/joaohenrique/NetBeansProjects/argentum/argentum/argentum");
        chooser.setFileFilter(new FileNameExtensionFilter("Apenas XML", "xml"));
        int retorno = chooser.showOpenDialog(null);
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            FileReader reader = new FileReader(chooser.getSelectedFile());
            List<Negocio> negocios = new LeitorXML().carrega(reader);
            
            Negocio primeiroNegocio = negocios.get(0);
            String mensagem = "Primeiro negócio: " + primeiroNegocio.getPreco();
            JOptionPane.showMessageDialog(null, mensagem);
        }
    }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

