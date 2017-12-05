/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indicadores;

import java.util.List;
import main.Candle;

/**
 *
 * @author joaohenrique
 */
public class SerieTemporal {
    
    private final List<Candle> candles;
    
    public SerieTemporal(List<Candle> candles){
        this.candles = candles;
    }
    
    public Candle getCandle(int i){
        return this.candles.get(i);
    }
    
    public int getTotal(){
        return this.candles.size();
    }
}
