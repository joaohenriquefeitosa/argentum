/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import junit.framework.Assert;
import main.Negocio;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joaohenrique
 */
public class NegocioTest {
    @Test
    public void dataDoNegocioEhImutavel(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 15);
        Negocio n = new Negocio(10, 5, c);
        
        n.getData().set(Calendar.DAY_OF_MONTH, 20);
        
        assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void naoCriaNegocioComDataNula(){
        new Negocio(10,5,null);
    }
    
    @Test
    public void mesmoMilissegundoEhDoMesmoDia(){
        Calendar agora = Calendar.getInstance();
        Calendar mesmoMomento = (Calendar) agora.clone();
        
        Negocio negocio = new Negocio(40.0, 100, agora);
        assertTrue(negocio.isMesmoDia(mesmoMomento));
    }    
    
    @Test
    public void mesmoDiaHorasDiferentesEhDoMesmoDia(){
        Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
        Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);
        
        Negocio negocio = new Negocio(40.0, 100, manha);
        assertTrue(negocio.isMesmoDia(tarde));
    }
    
    @Test
    public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia(){
        Calendar diaUm = new GregorianCalendar(2011, 11, 20);
        Calendar diaDois = new GregorianCalendar(2011, 10, 20);
        
        Negocio negocio = new Negocio(40.0, 100, diaUm);
        assertFalse(negocio.isMesmoDia(diaDois));
    }
    
    @Test
    public void mesmoDiaEMesMasAnosDifrentesNaoSaoDoMesmoDia(){
        Calendar diaUm = new GregorianCalendar(2012, 10, 20);
        Calendar diaDois = new GregorianCalendar(2011, 10, 20);
        
        Negocio negocio = new Negocio(40.0, 100, diaUm);
        assertFalse(negocio.isMesmoDia(diaDois));
    }
}                   