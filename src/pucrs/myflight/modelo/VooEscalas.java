package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo
{
    private Duration duracao;
    private Rota rota;
    private ArrayList<Rota> escala;

    public VooEscalas(LocalDateTime dataHora, Rota rota, Duration duracao){
        super(dataHora);
        escala = new ArrayList<>();
        this.rota = rota;
        this.duracao = duracao;
    }

    public void adicionaRota(Rota parada){
        escala.add(parada);
    }

    public Duration getDuracao() {
       return duracao;
    }

    public ArrayList<Rota> getRotas(){
        return escala;
    }

    public Rota getRota() {
        return rota;
    }

    public String toString(){
        return String.format("%s \t %s",rota, duracao)+super.toString();
    }
}