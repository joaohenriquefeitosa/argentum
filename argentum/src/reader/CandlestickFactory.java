package reader;

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
        double maximo = negocios.get(0).getPreco();
        double minimo = negocios.get(0).getPreco();
        double volume = 0;
        
        for (Negocio negocio : negocios) {
            volume += negocio.getVolume();
            if(negocio.getPreco() > maximo)
                maximo = negocio.getPreco();
            else if(negocio.getPreco() < minimo)
                minimo = negocio.getPreco();
        }
        
        double abertura = negocios.get(0).getPreco();
        double fechamento = negocios.get(negocios.size() - 1).getPreco();
        
        return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
    }
}
