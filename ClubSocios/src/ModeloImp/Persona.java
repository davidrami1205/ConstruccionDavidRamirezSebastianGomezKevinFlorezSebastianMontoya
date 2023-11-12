package ModeloImp;

import java.util.ArrayList;

public class Persona {
	private String nombre;
	private int cedula;
	private ArrayList<Factura> f_sinPagar;
	
	public Persona() {
		this.setF_SinPagar(new ArrayList<Factura>());
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public ArrayList<Factura> getF_SinPagar() {
		return f_sinPagar;
	}

	public void setF_SinPagar(ArrayList<Factura> f_SinPagar) {
		this.f_sinPagar = f_SinPagar;
	}
	
}

