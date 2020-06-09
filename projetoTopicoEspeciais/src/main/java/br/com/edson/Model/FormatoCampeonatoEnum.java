package br.com.edson.Model;

public enum FormatoCampeonatoEnum {
	
	FASEGRUPOSFINAS ("Fase de grupos finais"), MATAMATA ("Mata mata"), PONTOSCORRIDOS("Pontos corridos");
	
	private String descricao;

	private FormatoCampeonatoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	

}
