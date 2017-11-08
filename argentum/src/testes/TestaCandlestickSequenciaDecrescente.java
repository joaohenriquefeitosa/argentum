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
public class TestaCandlestickSequenciaDecrescente {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();
        
        Negocio negocio1 = new Negocio(40.5, 100, hoje);
        Negocio negocio2 = new Negocio(45.0, 100, hoje);
        Negocio negocio3 = new Negocio(49.8, 100, hoje);
        Negocio negocio4 = new Negocio(53.3, 100, hoje);
                
        List<Negocio> negocios = Arrays.asList(negocio4, negocio3, negocio2, negocio1);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
        
        System.out.println(candle.toString());
    }
}
