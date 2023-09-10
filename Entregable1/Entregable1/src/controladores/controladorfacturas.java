package controladores;

public interface controladorfacturas {
	public String validarcocepto(String concepto)throws Exception;
	public double validarvalor(double valor)throws Exception;
	public String validargenerador(String generador)throws Exception;
	
}
