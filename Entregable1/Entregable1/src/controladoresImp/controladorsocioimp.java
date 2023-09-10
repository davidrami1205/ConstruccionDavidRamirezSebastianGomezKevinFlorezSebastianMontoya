package controladoresImp;
import controladores.controladorsocio;
import modelo.socios;


public class controladorsocioimp extends socios implements controladorsocio  {

	public controladorsocioimp(String cedula, String nombre, String tipoSuscripcion) {
		super(cedula, nombre, tipoSuscripcion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String validarnombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validarcedula(String cedula) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validartipoSuscripcion(String tipoSuscripcion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
