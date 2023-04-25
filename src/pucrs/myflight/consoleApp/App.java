package pucrs.myflight.consoleApp;
import java.time.Duration;
import java.time.LocalDateTime;
import pucrs.myflight.modelo.Aeronave;
import pucrs.myflight.modelo.Aeroporto;
import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.GerenciadorAeronaves;
import pucrs.myflight.modelo.GerenciadorAeroportos;
import pucrs.myflight.modelo.GerenciadorCia;
import pucrs.myflight.modelo.GerenciadorRotas;
import pucrs.myflight.modelo.GerenciadorVoos;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.Voo;
import pucrs.myflight.modelo.Voo.Status;
import pucrs.myflight.modelo.VooDireto;
import pucrs.myflight.modelo.VooEscalas;

public class App {

	public static void main(String[] args) {
		System.out.println("\nMyFlight project...\n");

		CiaAerea compAerea1 = new CiaAerea("JJ","LATAM Linhas Areas");
		CiaAerea compAerea2 = new CiaAerea("G3", "Gol Linhas Aéreas SA");
		CiaAerea compAerea3 = new CiaAerea("TP", "TAP Portugal");
		CiaAerea compAerea4 = new CiaAerea("AD", "Azul Linhas Aéreas");

		Aeronave nave1 = new Aeronave("733", "Boeign 737-300", 140);
		Aeronave nave2 = new Aeronave("738", "Boeign 737-700", 126);
		Aeronave nave3 = new Aeronave("380", "Airbus Industrie A380", 644);
		Aeronave nave4 = new Aeronave("764", "Boeign 767-400", 304);

		Geo loc1 = new Geo(29.9939, 51.1711);
		Geo loc2 = new Geo(23.4356, 46.4731);
		Geo loc3 = new Geo(38.7742,9.1342);
		Geo loc4 = new Geo(25.7933, 80.2906);

		Aeroporto porto1 = new Aeroporto("POA", "Salgado Filho Intl apt",loc1);
		Aeroporto porto2 = new Aeroporto("GRU", "São Paulo Guarulhos Intl apt",loc2);
		Aeroporto porto3 = new Aeroporto("LIS", "Lisbon Intl apt",loc3);
		Aeroporto porto4 = new Aeroporto("MIA", "Miami Intenational apt",loc4);

		Rota r1 = new Rota(compAerea2, porto2, porto1, nave2);
		Rota r2 = new Rota(compAerea4, porto1, porto2, nave1);
		Rota r3 = new Rota(compAerea3, porto4, porto3, nave3);
		Rota r4 = new Rota(compAerea1, porto2, porto4, nave4);
		Rota r5 = new Rota(compAerea1, porto3, porto2, nave2);

		LocalDateTime ldt1 = LocalDateTime.of(2016, 8, 10, 8,0);
		LocalDateTime ldt2 = LocalDateTime.of(2016, 8, 10, 15, 0);
		LocalDateTime ldt3 = LocalDateTime.of(2016, 8, 15, 12, 0);

		Duration d1 = Duration.ofMinutes(90);
		Duration d2 = Duration.ofMinutes(120);
		Duration d3 = Duration.ofMinutes(120);

		Voo v1 = new VooDireto(ldt1, r2, d1);
		v1.setStatus(Status.ATRASADO);
		Voo v2 = new VooDireto(ldt2, r1, d2);
		v2.setStatus(Status.CONFIRMADO);
		Voo v3 = new VooDireto(ldt3, r3, d3);
		v3.setStatus(Status.CANCELADO);
		Voo v4 = new VooDireto(ldt1, r5, d2);
		v4.setStatus(Status.CONFIRMADO);

		//System.out.println("Aeronave: "+nave1.toString());
		//System.out.println("Aeroporto: "+porto1.toString());
		//System.out.println("Companhia aerea: "+compAerea1.toString());
		//System.out.println("Latitude e Longitude: "+loc1.toString());

		GerenciadorAeronaves gerenciadorAeronaves = GerenciadorAeronaves.getInstance();

		gerenciadorAeronaves.inserir(nave1);
		gerenciadorAeronaves.inserir(nave2);
		gerenciadorAeronaves.inserir(nave3);
		gerenciadorAeronaves.inserir(nave4);

		//System.out.println(gerenciadorAeronaves.toString());
		System.out.println("\nAERONAVES");
		for(Aeronave gn : gerenciadorAeronaves.listarTodasAeronaves()){
			System.out.println(" >>> ");
			System.out.println(gn);
		}

		System.out.println("\nORDENANDO AERONAVES");
		gerenciadorAeronaves.ordenaDescricao();
		for(Aeronave gn : gerenciadorAeronaves.listarTodasAeronaves()){
			System.out.println(" >>> ");
			System.out.println(gn);
		}

		GerenciadorAeroportos gerencidaorAeroportos = GerenciadorAeroportos.getInstance();

		gerencidaorAeroportos.adicionar(porto1);
		gerencidaorAeroportos.adicionar(porto2);
		gerencidaorAeroportos.adicionar(porto3);
		gerencidaorAeroportos.adicionar(porto4);

		//System.out.println(gerencidaorAeroportos.toString());
		System.out.println("\nAEROPORTOS");
		for(Aeroporto gp : gerencidaorAeroportos.listarTodosAeroportos()){
			System.out.println(" >>> ");
			System.out.println(gp);
		}

		System.out.println("\n ORDENANDO AEROPORTOS");
		gerencidaorAeroportos.ordenaNome();
		for(Aeroporto gp : gerencidaorAeroportos.listarTodosAeroportos()){
			System.out.println(" >>> ");
			System.out.println(gp);
		}

		GerenciadorCia gerenciadorCia = GerenciadorCia.getInstance();

		gerenciadorCia.inserir(compAerea1);
		gerenciadorCia.inserir(compAerea2);
		gerenciadorCia.inserir(compAerea3);
		gerenciadorCia.inserir(compAerea4);

		//System.out.println(gerenciadorCia.toString());
		System.out.println("\nCOMPANHIA AEREA");
		for(CiaAerea gc : gerenciadorCia.listarTodasCiaAerea()){
			System.out.println(" >>> ");
			System.out.println(gc);
		}
		GerenciadorRotas gerenciadorRotas = GerenciadorRotas.getInstance();

		gerenciadorRotas.adicionar(r1);
		gerenciadorRotas.adicionar(r2);
		gerenciadorRotas.adicionar(r3);
		gerenciadorRotas.adicionar(r4);
		
		//System.out.println(gerenciadorRotas.toString());
		System.out.println("\nROTAS");
		for(Rota gr : gerenciadorRotas.listarTodasRotas()){
			System.out.println(" >>> ");
			System.out.println(gr);
		}

		GerenciadorVoos gerenciadorVoos = GerenciadorVoos.getInstance();

		gerenciadorVoos.adicionar(v1);
		gerenciadorVoos.adicionar(v2);
		gerenciadorVoos.adicionar(v3);

		//System.out.println(gerenciadorVoos.toString());
		System.out.println("\nVOOS");
		for(Voo v : gerenciadorVoos.listarTodosVoos()){
			System.out.println(" >>> ");
			System.out.println(v);
		}

		System.out.println("\n"+"Rota: "+r1.toString()+"\n");
		System.out.println("Voo: "+v1.toString()+"\n");

		System.out.print("DISTANCIA de Porto Alegre a São Paulo é: ");
		double distancia = loc1.distancia(loc2);
		System.out.printf("%.3f\n",distancia);

		System.out.println("\nVoo com Escala\n");
		VooEscalas ve = new VooEscalas(ldt1, r3, d1);
		System.out.println(ve.toString()+"\n");
		ve.adicionaRota(r5);
		ve.adicionaRota(r1);
		//System.out.println(ve.toString());
		for(Rota v : ve.getRotas()){
			System.out.println(">>>");
			System.out.println(v);
		}
	}
}
