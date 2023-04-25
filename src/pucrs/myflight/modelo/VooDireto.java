package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo{
    
    private Rota rota;
    private Duration duracao;

    public VooDireto(LocalDateTime dataHora, Rota rota, Duration duracao){
        super(dataHora);
        this.rota = rota;
        this.duracao = duracao;
    }

    public Duration getDuracao(){
        return duracao;
    }

    public Rota getRota(){
        return rota;
    }

    @Override
	public String toString(){
		return String.format("%s \t %s",rota, duracao)+super.toString();
	}
}
