package entregable1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class socios {
	
	private String cedula;
	private String nombre;
	private double fondos_disp;
	private String t_suscripcion;
	private List<facturas> facturas_sin;
	private List<persona_autorizada> personas_auto;
	
	public socios(String cedula, String nombre, String t_suscripcion) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.t_suscripcion = t_suscripcion;
		this.facturas_sin = new ArrayList<>();
		this.personas_auto = new ArrayList<>();
	
	
		if (t_suscripcion.equals("VIP")) {
		
			this.fondos_disp = 100000.0;
        
		}	else {
    	
			this.fondos_disp = 50000.0;
		}

	}
	
	public boolean agregarPersonaAutorizada(String nombre) {
        if (fondos_disp >= 0 && personas_auto.size() < 10) {
            persona_autorizada autorizada = new persona_autorizada(nombre);
            personas_auto.add(autorizada);
            return true;
        }
        return false;
    }
	
	public boolean pagarFactura(facturas factura) {
        if (fondos_disp >= factura.getValor()) {
            fondos_disp -= factura.getValor();
            facturas_sin.remove(factura);
            return true;
        }
        return false;
    }
	
	public double getTotalConsumo() {
		
		double total = 0;
		for(facturas factura : facturas_sin) {
			total += factura.getValor();
		}
		
		for(persona_autorizada autorizada : personas_auto) {
			
			Stack<facturas> facturaAutorizada = autorizada.getFacturas();
			for(facturas factura : facturaAutorizada) {
				
				total += factura.getValor();
				
			}
		}return total;
	}

	public double getFondos_disp() {
		return fondos_disp;
	}

	public String getT_suscripcion() {
		return t_suscripcion;
	}

	public List<facturas> getFacturas_sin() {
		return facturas_sin;
	}

	public List<persona_autorizada> getPersonas_auto() {
		return personas_auto;
	}

	
}


		

