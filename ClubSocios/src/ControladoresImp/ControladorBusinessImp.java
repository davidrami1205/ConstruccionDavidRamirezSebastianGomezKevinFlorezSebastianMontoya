package ControladoresImp;

import Controladores.ControladorPersonasBusiness;
import ModeloImp.Club;
import ModeloImp.Socio;

public class ControladorBusinessImp implements ControladorPersonasBusiness{
	@Override
	public void validadorCedulaSocio(Club club, int cedula) throws Exception {
		for(Socio socios : club.getSocios()) {
			if (socios.getPersona().getCedula()==cedula) {
				throw new Exception("Ya existe un Socio con esa Cedula");
			}
		}
	}
		
}
