/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indicadores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import main.Candlestick;

/**
 *
 * @author joaohenrique
 */
public class GeradorDeSerie {
    
    /**
     * Serve para ajudar a fazer os testes.
     * 
     *  Recebe uma sequencia de valores e cria candlescom abertura, fechamento,
     *  minimo e maximo iguais, mil de volume e data de hoje. Finalmente, devolve
     *  tais candles encapsuladas em uma Serie Tempora.
     **/
    public static SerieTemporal criaSerie(double... valores){
        List<Candlestick> candles = new ArrayList<Candlestick>();
        for(double d : valores){
            candles.add(new Candlestick(d, d, d, d, 1000, Calendar.getInstance()));
        }
        return new SerieTemporal(candles);
    }
}
