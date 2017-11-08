package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaohenrique
 */
public class Candlestick {
    /* Preço da primeira negociação do dia */
    private final double abertura;
    /* Preço da última negociação do dia */
    private final double fechamento;
    /* Preço da negociação mais barata do dia */
    private final double minimo;
    /* Preço da negociação mais cara do dia */
    private final double maximo;
    /* Quantidade de dinheiro que passou em todas as negociações nesse dia */
    private final double volume;
    /* Qual dia o resumo se refere */
    private final Calendar data;

    public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volumen, Calendar data) {
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volumen;
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

    public double getVolume() {
        return volume;
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
    
    @Override
    public String toString(){
        
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
                     
        return "[ Abertura: " + this.abertura + ", Fechamento: " + this.fechamento + 
                ", Mínima: " + this.minimo + ", Máxima: " + this.maximo + ", Volume: " + this.volume + 
                ", Data: " + (dataFormatada.format(this.data.getTime())) + " ]";
    }
}
