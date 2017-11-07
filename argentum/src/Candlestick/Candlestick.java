package Candlestick;

import java.util.Calendar;

/**
 *
 * @author joaohenrique
 */
public class Candlestick {
    private final double abertura;
    private final double fechamento;
    private final double minimo;
    private final double maximo;
    private final double volumen;
    private final Calendar data;

    public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volumen, Calendar data) {
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volumen = volumen;
        this.data = data;
    }

    public double getAbertura() {
        return abertura;
    }

    public double getFechamento() {
        return fechamento;
    }

    public double getMinimo() {
        return minimo;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getVolumen() {
        return volumen;
    }

    public Calendar getData() {
        return data;
    }
    
    public boolean isAlta(){
        return this.abertura < this.fechamento;
    }
    
    public boolean isBaixa(){
        return this.abertura > this.fechamento;
    }
}
