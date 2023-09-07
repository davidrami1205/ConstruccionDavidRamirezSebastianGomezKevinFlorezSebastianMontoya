package entregable1;

import java.util.Stack;

public class persona_autorizada {

	private String nombre;
	private Stack<facturas> factura;
	
    public persona_autorizada (String nombre) {
        this.nombre = nombre;
        this.factura = new Stack<>();
    }

    public Stack<facturas> getFacturas() {
        return factura;
    }
	
}
