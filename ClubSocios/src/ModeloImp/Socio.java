package ModeloImp;

import java.util.ArrayList;
import java.util.List;

public class Socio {
	private String t_suscripción;
	private Persona per;
	private int f_disponibles;
	private List<PersonaAutorizada> p_autorizada;
	
	public Socio() {
	        this.setP_autorizada(new ArrayList<PersonaAutorizada>());
	    }
	
	public String getT_suscripción() {
		return t_suscripción;
	}
	
	public void setT_suscripción(String t_suscripción) {
		this.t_suscripción = t_suscripción;		
		if (t_suscripción.equalsIgnoreCase("VIP"))
			this.setF_disponibles(100000);
		if (t_suscripción.equalsIgnoreCase("Regular"))
			this.setF_disponibles(50000);
	}
	
	public Persona getPersona() {
		return per;
	}
	
	public void setPersona(Persona per) {
		this.per = per;
	}
	
	public int getF_disponibles() {
		return f_disponibles;
	}
	
	public void setF_disponibles(int f_disponibles) {
		this.f_disponibles = f_disponibles;
	}
	
	public List<PersonaAutorizada> getP_autorizada() {
		return p_autorizada;
	}

	public void setP_autorizada(List<PersonaAutorizada> p_autorizada) {
		this.p_autorizada = p_autorizada;
	}

	public String mostrarDatos() {
		return "\n Cedula: " + per.getCedula() +
				"\n Nombre: " + per.getNombre() +
				"\n Tipo de Suscripcion: " + getT_suscripción() +
				"\n Fondos Disponibles: " + getF_disponibles();				
	}
	
	public void aumentarFondos(int montoAumento) {
        int fondoMaximo;
        	if (getT_suscripción().equalsIgnoreCase("VIP")) {
        			fondoMaximo = 5000000;
        		} else if (getT_suscripción().equalsIgnoreCase("Regular")) {
        			fondoMaximo = 1000000;
        		} else {System.out.println("Error: Tipo de suscripción no válido.");
        		return;
        			}if (getF_disponibles() + montoAumento > fondoMaximo) {
        				System.out.println("Error: El aumento excede el fondo máximo permitido.");
        				return;
        			}setF_disponibles(getF_disponibles() + montoAumento);
        			System.out.println("Aumento de fondos exitoso. Fondos actuales: " + getF_disponibles());}
	
}
