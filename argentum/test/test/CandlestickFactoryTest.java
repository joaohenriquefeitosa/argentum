package test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import main.Candlestick;
import main.Negocio;
import org.junit.Test;
import static org.junit.Assert.*;
import reader.CandlestickFactory;

/**
 *
 * @author joaohenrique
 */
public class CandlestickFactoryTest {
    
    @Test
    public void sequenciaSimplesDeNegocios(){
        Calendar hoje = Calendar.getInstance();
        
        Negocio negocio1 = new Negocio(40.5, 100, hoje);
        Negocio negocio2 = new Negocio(45.0, 100, hoje);
        Negocio negocio3 = new Negocio(39.8, 100, hoje);
        Negocio negocio4 = new Negocio(42.3, 100, hoje);
        
        List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3, negocio4);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
        
        assertEquals(40.5, candle.getAbertura(), 0.00001);
        assertEquals(42.3, candle.getFechamento(), 0.00001);
        assertEquals(39.8, candle.getMinimo(), 0.00001);
        assertEquals(45.0, candle.getMaximo(), 0.00001);
        assertEquals(16760.0, candle.getVolume(), 0.00001);        
    }
    
    @Test
    public void semNegociosGeraCandleComZeros(){
        Calendar hoje = Calendar.getInstance();
        
        List<Negocio> negocios = Arrays.asList();
        
        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
        
        assertEquals(0.0, candle.getAbertura(), 0.00001);
        assertEquals(0.0, candle.getFechamento(), 0.00001);
        assertEquals(0.0, candle.getMaximo(), 0.00001);        
        assertEquals(0.0, candle.getMinimo(), 0.00001);
        assertEquals(0.0, candle.getVolume(), 0.00001);
        
    }
    
    @Test
    public void apenasUmNegocioGeraCandleComValoresIguais(){
        Calendar hoje = Calendar.getInstance();
        
        Negocio negocio1 = new Negocio(40.5, 100, hoje);
        
        List<Negocio> negocios = Arrays.asList(negocio1);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
        
        assertEquals(40.5, candle.getAbertura(), 0.00001);
        assertEquals(40.5, candle.getFechamento(), 0.00001);
        assertEquals(40.5, candle.getMinimo(), 0.00001);
        assertEquals(40.5, candle.getMaximo(), 0.00001);
        assertEquals(4050.0, candle.getVolume(), 0.00001);        
    }
    
    @Test
    public void negociosEmOrdemCrescenteDeValor(){
        Calendar hoje = Calendar.getInstance();
        
        Negocio negocio1 = new Negocio(40.5, 100, hoje);
        Negocio negocio2 = new Negocio(45.0, 100, hoje);
        Negocio negocio3 = new Negocio(49.8, 100, hoje);
        Negocio negocio4 = new Negocio(53.3, 100, hoje);
                
        List<Negocio> negocios = Arrays.asList(negocio1, negocio2, negocio3, negocio4);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
        
        assertEquals(40.5, candle.getAbertura(), 0.00001);
        assertEquals(53.3, candle.getFechamento(), 0.00001);
        assertEquals(40.5, candle.getMinimo(), 0.00001);
        assertEquals(53.3, candle.getMaximo(), 0.00001);
        assertEquals(18860.0, candle.getVolume(), 0.00001);  
    }
    
    @Test
    public void negociosEmOrdemDescrescentDeValor(){
        Calendar hoje = Calendar.getInstance();
        
        Negocio negocio1 = new Negocio(40.5, 100, hoje);
        Negocio negocio2 = new Negocio(45.0, 100, hoje);
        Negocio negocio3 = new Negocio(49.8, 100, hoje);
        Negocio negocio4 = new Negocio(53.3, 100, hoje);
                
        List<Negocio> negocios = Arrays.asList(negocio4, negocio3, negocio2, negocio1);
        
        CandlestickFactory fabrica = new CandlestickFactory();
        
        Candlestick candle = fabrica.constroiCandleParaData(hoje, negocios);
        
        assertEquals(53.3, candle.getAbertura(), 0.00001);
        assertEquals(40.5, candle.getFechamento(), 0.00001);
        assertEquals(40.5, candle.getMinimo(), 0.00001);
        assertEquals(53.3, candle.getMaximo(), 0.00001);
        assertEquals(18860.0, candle.getVolume(), 0.00001);  
    }
}
