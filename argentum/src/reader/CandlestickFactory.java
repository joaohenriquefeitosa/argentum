package reader;

import java.util.ArrayList;
import main.Candlestick;
import main.Negocio;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author joaohenrique
 */
public class CandlestickFactory {
    public Candlestick constroiCandleParaData(Calendar data, List<Negocio> negocios){
        double maximo = negocios.isEmpty() ? 0 : Double.MIN_VALUE;
        double minimo = negocios.isEmpty() ? 0 : Double.MAX_VALUE;
        double volume = 0;
        
        
        for (Negocio negocio : negocios) {
            volume += negocio.getVolume();
            if(negocio.getPreco() > maximo)
                maximo = negocio.getPreco();
            else if(negocio.getPreco() < minimo)
                minimo = negocio.getPreco();
        }
        
        if(negocios.size() == 1){
            minimo = maximo;
        }
        
        double abertura = negocios.isEmpty() ? 0 : negocios.get(0).getPreco();
        double fechamento = negocios.isEmpty() ? 0 : negocios.get(negocios.size() - 1).getPreco();
        
        return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
    }

    public List<Candlestick> constroiCandles(List<Negocio> todosNegocios) {
        List<Candlestick> candles = new ArrayList<Candlestick>();
        
        List<Negocio> negociosDoDia = new ArrayList<Negocio>();
        Calendar dataAtual = todosNegocios.get(0).getData();
        
        for(Negocio negocio : todosNegocios){
            // se não for mesmo dia, fecha candles e reinicia variáveis
            if(!negocio.isMesmoDia(dataAtual)){
                Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociosDoDia);
                candles.add(candleDoDia);
                negociosDoDia = new ArrayList<Negocio>();
                dataAtual = negocio.getData();
            }
            negociosDoDia.add(negocio);           
        }
        // adiciona último candle
           Candlestick candleDoDia = constroiCandleParaData(dataAtual, negociosDoDia);
           candles.add(candleDoDia);
            
           return candles;
        
    }
}
