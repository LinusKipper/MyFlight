package pucrs.myflight.modelo;

public class CiaAerea implements Comparable<CiaAerea>{
	private String codigo;
	private String nome;
	
	public CiaAerea(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public int compareTo(CiaAerea outro) {
		return nome.compareTo(outro.nome);
	}

	@Override
	public String toString(){
		return String.format("(%s) \t Cia aerea %s",codigo, nome);
	}
}
