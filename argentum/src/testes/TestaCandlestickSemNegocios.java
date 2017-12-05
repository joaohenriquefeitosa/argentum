package testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import main.Candle;
import main.Negocio;
import reader.CandlestickFactory;

/**
 *
 * @author joaohenrique
 */
public class TestaCandlestickSemNegocios {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
        
        List<Negocio> negocios = Arrays.asList();
        
        CandlestickFactory fabrica = new CandlestickFactory();
        Candle candle = fabrica.constroiCandleParaData(hoje, negocios);
        
        System.out.println(candle.toString());
    }
}
