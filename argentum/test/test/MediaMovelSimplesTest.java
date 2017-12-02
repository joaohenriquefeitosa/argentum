/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import indicadores.GeradorDeSerie;
import indicadores.MediaMovelSimples;
import indicadores.SerieTemporal;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author joaohenrique
 */
public class MediaMovelSimplesTest {
    
    @Test
    public void sequenciaSimplesDeCandles() throws Exception{
        SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 3, 4, 5, 4, 3);
        MediaMovelSimples mms = new MediaMovelSimples();
        
        assertEquals(2.0, mms.calcula(2, serie), 0.00001);
        assertEquals(3.0, mms.calcula(3, serie), 0.00001);
        assertEquals(10.0/3, mms.calcula(4, serie), 0.0001);
        assertEquals(11.0/3, mms.calcula(5, serie), 0.0001);
        assertEquals(4.0, mms.calcula(6, serie), 0.00001);
        assertEquals(13.0/3, mms.calcula(7, serie), 0.00001);
        assertEquals(4.0, mms.calcula(8, serie), 0.00001);
    }
    
}
