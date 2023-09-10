package controladoresImp;
import controladores.controladorfacturas;
import modelo.facturas;

public class controladorfacturasimp extends facturas implements controladorfacturas {

	public controladorfacturasimp(String concepto, double valor, String generador) {
		super(concepto, valor, generador);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String validarcocepto(String concepto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double validarvalor(double valor) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String validargenerador(String generador) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
	
