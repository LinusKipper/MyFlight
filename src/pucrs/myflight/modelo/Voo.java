package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Voo{
	
	public enum Status { CONFIRMADO, ATRASADO, CANCELADO };
	
	private LocalDateTime datahora;
	private Status status;
	
	public Voo(LocalDateTime datahora) {
		this.datahora = datahora;
		this.status = Status.CONFIRMADO; // default é confirmado
	}
	
	public abstract Rota getRota();
	
	public LocalDateTime getDatahora() {
		return datahora;
	}
	
	public abstract Duration getDuracao();
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status novo) {
		this.status = novo;
	}

	@Override
	public String toString(){
		return String.format(" data e hora %s \t  status %s", datahora, status);
	}
}
