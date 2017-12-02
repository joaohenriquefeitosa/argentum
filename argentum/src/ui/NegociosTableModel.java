/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import main.Negocio;

/**
 *
 * @author joaohenrique
 */
public class NegociosTableModel extends AbstractTableModel{
    
    private final List<Negocio> lista;

    public NegociosTableModel(List<Negocio> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Preço";
            case 1:
                return "Quantidade";
            case 2:
                return "Data";
        }
        return "";
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Negocio negocio = lista.get(linha);
        switch(coluna){
            case 0:
                Locale brasil = new Locale("pt", "BR");
                NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(brasil);
                return formatadorMoeda.format(negocio.getPreco());
            case 1:
                return negocio.getQuantidade();
            case 2:
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                return sdf.format(negocio.getData().getTime());
        }
        return "";
    }
    
}
