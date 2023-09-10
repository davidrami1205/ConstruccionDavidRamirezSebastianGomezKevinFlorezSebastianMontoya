package modelo;

import java.util.Stack;

public class personasAutorizadas {
	private String nombre;
    private Stack<facturas> Factura;

    public personasAutorizadas(String nombre) {
        this.nombre = nombre;
        this.Factura = new Stack<>();
    }

    public Stack<facturas> getFacturas() {
        return Factura;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
