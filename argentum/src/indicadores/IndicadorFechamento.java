/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indicadores;

/**
 *
 * @author joaohenrique
 */
public class IndicadorFechamento implements Indicador{

    @Override
    public double calcula(int posicao, SerieTemporal serie) {
        return serie.getCandle(posicao).getFechamento();
    }
    
    @Override
    public String toString(){
        return "Indicador de fechamento";
    }
    
}
