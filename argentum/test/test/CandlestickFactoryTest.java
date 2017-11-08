package test;

import java.util.Calendar;
import main.Negocio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaohenrique
 */
public class CandlestickFactoryTest {
    
    @Test
    public void sequenciaSimplesDeNegocios(){
        Calendar hoje = Calendar.getInstance();
        
        Negocio negocio1 = new Negocio(40.5, 100, hoje);
        Negocio negocio2 = new Negocio(40.5, 100, hoje);
        Negocio negocio3 = new Negocio(40.5, 100, hoje);
        Negocio negocio4 = new Negocio(40.5, 100, hoje);
        
        
        
    }    
}
