package main;

import java.util.Calendar;

/**
 *
 * @author joaohenrique
 */
public class CandleBuilder {
    
    private double abertura;
    private double fechamento;
    private double minimo;
    private double maximo;
    private int volume;
    private Calendar data;
    
    public CandleBuilder comAbertura(double abertura){
        this.abertura = abertura;
        return this;
    }
    
    public CandleBuilder comFechamento(double fechamento){
        this.fechamento = fechamento;
        return this;
    }
    
    public CandleBuilder comMinimo(double minimo){
        this.minimo = minimo;
        return this;
    }
    
    public CandleBuilder comMaximo(double maximo){
        this.maximo = maximo;
        return this;
    }
    
    public CandleBuilder comVolume(int volume){
        this.volume = volume;
        return this;
    }
    
    public CandleBuilder comCalendar(Calendar data){
        this.data = data;
        return this;
    }
    
    public Candle geraCandle(){
        return new Candle(abertura, fechamento, minimo, maximo, minimo, data);
    }
}
