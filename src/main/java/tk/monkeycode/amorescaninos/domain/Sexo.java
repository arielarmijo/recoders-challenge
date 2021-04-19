package tk.monkeycode.amorescaninos.domain;

public enum Sexo {

	MACHO("Macho"),
	HEMBRA("Hembra");
	
	private final String valor;
	
	private Sexo(String valor) {
		this.valor = valor;
	}
	
	public String getValue() {
		return valor;
	}
	
}
