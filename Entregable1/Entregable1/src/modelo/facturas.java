package modelo;

public class facturas {
	private String concepto;
    private double valor;
    private String generador;

    public facturas(String concepto, double valor, String generador) {
        this.concepto = concepto;
        this.valor = valor;
        this.generador = generador;
    }

    public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getGenerador() {
		return generador;
	}

	public void setGenerador(String generador) {
		this.generador = generador;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
        return valor;
    }

}


