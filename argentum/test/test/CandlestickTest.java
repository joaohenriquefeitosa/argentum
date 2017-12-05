package test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import main.Candle;
import main.Negocio;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import reader.CandlestickFactory;

/**
 *
 * @author joaohenrique
 */
public class CandlestickTest {
    
    @Test(expected=IllegalArgumentException.class)
    public void precoMaximoNaoPodeSerMenorQueMinimo(){
        new Candle(10, 20, 20, 10, 10000, Calendar.getInstance());        
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void dataNaoPodeSerNula(){
        new Candle(10, 20, 20, 40, 10000, null); 
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void naoAceitaValoresNegativos(){
        new Candle(-10, -20, 20, 40, 10000, Calendar.getInstance()); 
    }
    
    @Test
    public void paraNegociosDeTresDiasDistintosGeraTresCandles(){
        Calendar hoje = Calendar.getInstance();
        
        Negocio negocio1 = new Negocio(40.5, 100, hoje);
        Negocio negocio2 = new Negocio(45.0, 100, hoje);
        Negocio negocio3 = new Negocio(39.8, 100, hoje);
        Negocio negocio4 = new Negocio(42.3, 100, hoje);
        
        Calendar amanha = (Calendar) hoje.clone();
        amanha.add(Calendar.DAY_OF_MONTH, 1);
        
        Negocio negocio5 = new Negocio(48.8, 100, amanha);
        Negocio negocio6 = new Negocio(49.3, 100, amanha);
        
        Calendar depois = (Calendar) amanha.clone();
        depois.add(Calendar.DAY_OF_MONTH, 1);
        
        Negocio negocio7 = new Negocio(51.8, 100, depois);
        Negocio negocio8 = new Negocio(52.3, 100, depois);
        
        //List<Negocio> negocios = Arrays.asList(negocio3, negocio1, negocio4, negocio2, negocio5, negocio6, negocio7, negocio8);
        //List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3, negocio4, negocio5, negocio6, negocio7, negocio8);
        List<Negocio> negocios = Arrays.asList(negocio8, negocio7, negocio6, negocio5, negocio2, negocio4, negocio1, negocio3);
        CandlestickFactory fabrica = new CandlestickFactory();
        
        List<Candle> candles = fabrica.constroiCandles(negocios);
        
        assertEquals(3, candles.size());
        assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);
        assertEquals(42.3, candles.get(0).getFechamento(), 0.00001);
        assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);
        assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);
        assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);        
        assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);
    }
}

