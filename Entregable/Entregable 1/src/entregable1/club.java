package entregable1;

import java.util.HashMap;
import java.util.Map;

public class club {
	
	private Map<String, socios> socio;
	
	public club() {
		
		this.socio = new HashMap<>();
		
	}
	
	public boolean afiliarsocios(String cedula, String nombre, String t_suscripcion) {
		
		if(socio.containsKey(cedula)) {
			
			return false;
		}
		
		if(socio.size()>= 35) {
			
			return false;
			
		}
		
		socios nuevosocio = new socios(cedula, nombre, t_suscripcion);
		socio.put(cedula, nuevosocio);
		return true;
	}
	
	public boolean registrarPersonaAutorizada(String cedulaSocio, String nombreAutorizado) {
		
		socios Socio = socio.get(cedulaSocio);
		
		if (Socio != null) {
			
			return ((socios) socio).agregarPersonaAutorizada(nombreAutorizado);			
		}
		return false;
	}
	
	public boolean pagarFactura(String cedulaSocio, String nombreFactura) {
		
		socios Socio = socio.get(cedulaSocio);
		
		if(Socio != null) {
			
			for(facturas factura : Socio.getFacturas_sin()) {
				
				if(factura.getGenerador().equals(nombreFactura)) {
					
					return Socio.pagarFactura(factura);
					
				}
			}
				
		}return false;
		
	}
	
	public boolean registrarConsumo(String cedulaSocio, String concepto, double valor, String generador) {
		
		socios Socio = socio.get(cedulaSocio);
		
		if(Socio != null) {
			
			facturas factura = new facturas(concepto, valor, generador);
			Socio.getFacturas_sin().add(factura);
			return true;
			
		}return false;
		
	}	
	
	public boolean aumentarFondos(String cedulaSocio, double monto) {
		
		socios Socio = socio.get(cedulaSocio);
		
		if (Socio != null && (Socio.getT_suscripcion().equals("VIP") && monto <= 5000000.0) || 
				(Socio.getT_suscripcion().equals("Regular") && monto <= 1000000.0)) {
			
			Socio.getFondos_disp(Socio.getFondos_disp() + monto);
			return true;
			
		}return false;
		
	}
	
	public boolean eliminarSocio(String cedulaSocio) {
		
		socios Socio = socio.get(cedulaSocio);
		if (Socio != null) {
			
			if (Socio.getT_suscripcion().equals("VIP") || 
				!Socio.getFacturas_sin().isEmpty() || Socio.getPersonas_auto().size() > 1) {
				return false;
				
			}socio.remove(cedulaSocio);
			return true;
			
		}return false;
		
	}
	
	public double consultarTotalConsumos(String cedulaSocio) {
		
		socios Socio = socio.get(cedulaSocio);
		
		if (Socio != null) {
			return Socio.getTotalConsumo();
			
		} return -1;
		
	}
	
}
