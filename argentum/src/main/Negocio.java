package main;

import java.util.Calendar;

/**
 *
 * @author joaohenrique
 */
public final class Negocio {
    private final double preco;
    private final int quantidade;
    private final Calendar data;

    public Negocio(double preco, int quantidade, Calendar data) {
        if(data == null){
            throw new IllegalArgumentException("Data não pode ser nula!");
        }
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
        return (Calendar) this.data.clone();
    }
    
    public double getVolume(){
        return preco * quantidade;
    }
}
