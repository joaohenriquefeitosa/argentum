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

    @Coluna(posicao=0)
    public double getPreco() {
        return preco;
    }
    
    @Coluna(posicao=1)
    public int getQuantidade() {
        return quantidade;
    }
    
    @Coluna(posicao=2)
    public Calendar getData() {
        return (Calendar) this.data.clone();
    }
    
    public double getVolume(){
        return preco * quantidade;
    }

    public boolean isMesmoDia(Calendar outraData) {
        return data.get(Calendar.DATE) == outraData.get(Calendar.DATE) && 
               data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH) &&
               data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
    }

}
