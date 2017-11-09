package test;

import java.util.Calendar;
import main.Candlestick;
import org.junit.Test;

/**
 *
 * @author joaohenrique
 */
public class CandlestickTest {
    
    @Test(expected=IllegalArgumentException.class)
    public void precoMaximoNaoPodeSerMenorQueMinimo(){
        new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());        
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void dataNaoPodeSerNula(){
        new Candlestick(10, 20, 20, 40, 10000, null); 
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void naoAceitaValoresNegativos(){
        new Candlestick(-10, -20, 20, 40, 10000, Calendar.getInstance()); 
    }
}

