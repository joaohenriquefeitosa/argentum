package Negocios;

import java.util.Calendar;

/**
 *
 * @author joaohenrique
 */
public final class Negocios {
    private final double preco;
    private final int quantidade;
    private final Calendar data;

    public Negocios(double preco, int quantidade, Calendar data) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Calendar getData() {
        return data;
    }
    
    public double getVolume(){
        return preco * quantidade;
    }
}
