package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooVariasEscalas extends Voo{

    private ArrayList<Voo> escalas;

    public VooVariasEscalas(Rota rota, LocalDateTime datahora, Duration duracao){
        super(rota, datahora, duracao);
        escalas = new ArrayList<>();
    }
   
    public void adicionar(Voo parada){
        escalas.add(parada);
    }

    public ArrayList<Voo> listarTodosVoos(){
        return escalas;
    }

    @Override
    public String toString(){
        return super.toString() + "\nROTA FINAL\n" + escalas;
    }
}
