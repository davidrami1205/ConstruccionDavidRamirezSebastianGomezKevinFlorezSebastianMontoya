package ModeloImp;

public class PersonaAutorizada {
	private Persona per;

	public Persona getPersona() {
		return per;
	}

	public void setPersona(Persona persona) {
		this.per = persona;
	}
	
	public String mostrarDatos() {
		return	"\n Cedula: " + per.getCedula() +
				"\n Nombre: " + per.getNombre();
	}
	
}
