package reader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.Reader;
import java.util.List;
import main.Negocio;

/**
 *
 * @author joaohenrique
 */
public class LeitorXML {
    public List<Negocio> carrega(Reader fonte){
        XStream stream = new XStream(new DomDriver());
        stream.alias("negocio", Negocio.class);
        return (List<Negocio>) stream.fromXML(fonte);
    }
}
