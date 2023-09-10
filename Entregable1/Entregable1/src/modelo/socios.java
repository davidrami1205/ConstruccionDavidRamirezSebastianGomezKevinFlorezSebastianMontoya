package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class socios  {
	 private String cedula;
	    private String nombre;
	    private double fondosDisponibles;
	    private String tipoSuscripcion;
	    private List<facturas> facturasSinPagar;
	    private List<personasAutorizadas> personasAuto;

	    public socios(String cedula, String nombre, String tipoSuscripcion) {
	        this.cedula = cedula;
	        this.nombre = nombre;
	        this.fondosDisponibles = 0;
	        this.tipoSuscripcion = tipoSuscripcion;
	        this.facturasSinPagar = new ArrayList<>();
	        this.personasAuto = new ArrayList<>();

	        if (tipoSuscripcion.equals("VIP")) {
	            this.fondosDisponibles = 100000.0;
	        } else {
	            this.fondosDisponibles = 50000.0;
	        }
	    }

	    public boolean agregarPersonaAutorizada(String nombre) {
	        if (fondosDisponibles >= 0 && personasAuto.size() < 10) { 
	            personasAutorizadas autorizada = new personasAutorizadas(nombre);
	            personasAuto.add(autorizada);
	            return true;
	        }
	        return false;
	    }

	    public boolean pagarFactura(facturas factura) {
	        if (fondosDisponibles >= factura.getValor()) {
	            fondosDisponibles -= factura.getValor();
	            facturasSinPagar.remove(factura);
	            return true;
	        }
	        return false;
	    }
	    

	    public double getTotalConsumos() {
	        double total = 0;
	        for (facturas factura : facturasSinPagar) {
	            total += factura.getValor();
	        }
	        for (personasAutorizadas autorizada : personasAuto) {
	            Stack<facturas> facturasAutorizada = autorizada.getFacturas();
	            for (facturas factura : facturasAutorizada) {
	                total += factura.getValor();
	            }
	        }
	        return total;
	    }

		public String getCedula() {
			return cedula;
		}

		public void setCedula(String cedula) {
			this.cedula = cedula;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public double getFondosDisponibles() {
			return fondosDisponibles;
		}

		public void setFondosDisponibles(double fondosDisponibles) {
			this.fondosDisponibles = fondosDisponibles;
		}

		public String getTipoSuscripcion() {
			return tipoSuscripcion;
		}

		public void setTipoSuscripcion(String tipoSuscripcion) {
			this.tipoSuscripcion = tipoSuscripcion;
		}

		public List<facturas> getFacturasSinPagar() {
			return facturasSinPagar;
		}

		public void setFacturasSinPagar(List<facturas> facturasSinPagar) {
			this.facturasSinPagar = facturasSinPagar;
		}

		public List<personasAutorizadas> getPersonasAuto() {
			return personasAuto;
		}

		public void setPersonasAuto(List<personasAutorizadas> personasAuto) {
			this.personasAuto = personasAuto;
		}

	    
	    
	}
	

