package test;

import java.io.StringReader;
import java.util.List;
import main.Negocio;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import reader.LeitorXML;

/**
 *
 * @author joaohenrique
 */
public class LeitorXMLTest {
    @Test
    public void carregaXmlComUmNegocioEmListaUnitaria(){
        String xmlDeTeste = "<list>" +
                            "    <negocio>" +
                            "        <preco>43.5</preco>" +
                            "        <quantidade>1000</quantidade>" +
                            "        <data>" +
                            "           <time>1322233344455</time>" +
                            "        </data>" +
                            "    </negocio>" +
                            "</list>";
        
        LeitorXML leitor = new LeitorXML();
        List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
        
        assertEquals(1, negocios.size(), 0.00001);
        assertEquals(43.5, negocios.get(0).getPreco(), 0.00001);
        assertEquals(1000, negocios.get(0).getQuantidade(), 0.00001);
    }
}
