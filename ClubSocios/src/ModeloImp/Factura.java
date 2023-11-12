package ModeloImp;

public class Factura {
	private int concepto;
	private Persona per;
	private int valor;
		
	public int getConcepto() {
		return concepto;
	}
	public void setConcepto(int concepto) {
		this.concepto = concepto;
	}
	public Persona getPer() {
		return per;
	}
	public void setPer(Persona per) {
		this.per = per;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String mostrarDatos() {
		return "\n cedula persona: " + per.getCedula() +
				"\n nombre persona: " + per.getNombre() +
				"\n concepto: " + getConcepto() +
				" \n valor: " + getValor();				
	}
	
	public boolean pagarFactura(Socio socio) {
	    if (socio.getF_disponibles() >= valor) {
	        socio.setF_disponibles(socio.getF_disponibles() - valor);
	        return true;
	    } else {
	        System.out.println("Error: Fondos insuficientes para pagar la factura.");
	        return false;  
	    }
	}
}
