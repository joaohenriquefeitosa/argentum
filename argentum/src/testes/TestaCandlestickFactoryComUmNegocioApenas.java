package testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import main.Candlestick;
import main.Negocio;
import reader.CandlestickFactory;

/**
 *
 * @author joaohenrique
 */
public class TestaCandlestickFactoryComUmNegocioApenas {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
        
        Negocio negocio1 = new Negocio(40.5, 100, hoje);
        
        List<Negocio> negocios = Arrays.asList(negocio1);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
        
        System.out.println(candle.toString());
    }
}
