package entregable1;

public class facturas {

	private String concepto;
	private double valor;
	private String generador;
	
	
	public facturas(String concepto, double valor, String generador) {
	//super();
		this.concepto = concepto;
		this.valor = valor;
		this.generador = generador;
	}

	public double getValor() {
		return valor;
	}

	public String getGenerador() {
		return generador;
	}


}
	
	

	

