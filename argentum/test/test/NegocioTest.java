/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Calendar;
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
    
    @Test(expected=IllegalArgumentExcepton.class)
    public 
    
}
