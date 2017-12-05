package reader;

import java.util.ArrayList;
import main.Candle;
import main.Negocio;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author joaohenrique
 */
public class CandlestickFactory {
    public Candle constroiCandleParaData(Calendar data, List<Negocio> negocios){
        double maximo = negocios.isEmpty() ? 0 : Double.MIN_VALUE;
        double minimo = negocios.isEmpty() ? 0 : Double.MAX_VALUE;
        double volume = 0;
        
        
        for (Negocio negocio : negocios) {
            volume += negocio.getVolume();
            
            double preco = negocio.getPreco();
            if(preco > maximo)
                maximo = preco;
            else if(preco < minimo)
                minimo = preco;
        }
        
        if(negocios.size() == 1){
            minimo = maximo;
        }
        
        double abertura = negocios.isEmpty() ? 0 : negocios.get(0).getPreco();
        double fechamento = negocios.isEmpty() ? 0 : negocios.get(negocios.size() - 1).getPreco();
        
        return new Candle(abertura, fechamento, minimo, maximo, volume, data);
    }

    public List<Candle> constroiCandles(List<Negocio> todosNegocios) {
        List<Candle> candles = new ArrayList<Candle>();
        
        List<Negocio> negociosDoDia = new ArrayList<Negocio>();
        Calendar dataAtual = todosNegocios.get(0).getData();
        
        for(Negocio negocio : todosNegocios){
            // se não for mesmo dia, fecha candles e reinicia variáveis
            if(!negocio.isMesmoDia(dataAtual)){
                this.criaEGuardaCandle(dataAtual, negociosDoDia, candles);
                negociosDoDia = new ArrayList<Negocio>();
                dataAtual = negocio.getData();
            }
            negociosDoDia.add(negocio);           
        }
        // adiciona último candle
        this.criaEGuardaCandle(dataAtual, negociosDoDia, candles);
        return candles;
        
    }
    
    private void criaEGuardaCandle(Calendar dataAtual, List<Negocio> negociosDoDia, List<Candle> candles){
        Candle candleDoDia = constroiCandleParaData(dataAtual, negociosDoDia);
        candles.add(candleDoDia);
    }
}
