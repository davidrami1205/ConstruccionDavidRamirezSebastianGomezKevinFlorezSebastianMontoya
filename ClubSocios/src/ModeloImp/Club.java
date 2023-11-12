package ModeloImp;

import java.util.ArrayList;

public class Club {
	private ArrayList<Socio> socios;
	private ArrayList<Factura> facturas;
	private ArrayList<PersonaAutorizada> p_autorizada;
	
	public Club() {
		this.setSocios(new ArrayList<Socio>());
		this.setP_autorizada(new ArrayList<PersonaAutorizada>());
		this.setFacturas(new ArrayList<Factura>());

	}

	public ArrayList<Socio> getSocios() {
		return socios;
	}

	public void setSocios(ArrayList<Socio> socios) {
		this.socios = socios;
	}

	public ArrayList<PersonaAutorizada> getP_autorizada() {
		return p_autorizada;
	}

	public void setP_autorizada(ArrayList<PersonaAutorizada> p_autorizada) {
		this.p_autorizada = p_autorizada;
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	
	public String mostrarSocios() {
		String socios = "Se ha registrado el socio con los siguientes datos: ";
		for(Socio socio : this.socios) {
			socios+= socio.mostrarDatos();
		}
		return socios;
	}
	
	public String mostrarP_autorizadas() {
		String p_autorizada = "Se ha registrado una persona autorizada con los siguientes datos: ";
		for(PersonaAutorizada perAutorizada: this.p_autorizada) {
			p_autorizada+= perAutorizada.mostrarDatos();
		}
		return p_autorizada;
	}
	
	public String mostrarFacturas() {
		String facturas = "Se ha generado la siguiente factura: ";
		for(Factura factura : this.facturas) {
			facturas+= factura.mostrarDatos();
		}
		return facturas;
	}
	
    public Socio buscarSocioPorCedula(int cedula) {
        for (Socio socio : socios) {
            if (socio.getPersona().getCedula() == cedula) {
                return socio;
            }
        }
        return null;
    }
    
    public Factura buscarFacturaPorNumero(int numeroFactura) {
	    for (Factura factura : facturas) {
	        if (factura.getConcepto() == numeroFactura) {
	            return factura;
	        }
	    }
	    return null;
	}
}
