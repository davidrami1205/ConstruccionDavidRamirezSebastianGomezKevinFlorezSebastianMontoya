package ControladoresImp;

import Controladores.ControladorPersonasInput;

public class ControladorInputImp extends ControladorInput implements ControladorPersonasInput{
	
	@Override
	public String validarNombre(String nombre) throws Exception {
		super.stringVacio(nombre, "Nombre Persona");
		return nombre;
	}
	
	@Override
	public int validarCedula(String cedula) throws Exception {
		return super.numeroValido(cedula, "Cedula persona");
	}
	
	@Override
	public String validarSuscripcion(String t_suscripcion) throws Exception {
		super.stringVacio(t_suscripcion, "Tipo de Suscripcion");
		if(!(t_suscripcion.equalsIgnoreCase("vip") || (t_suscripcion.equalsIgnoreCase("regular"))))
			throw new Exception("El Tipo de Suscripcion debe de ser VIP o Regular");
		return t_suscripcion;
	}

}
