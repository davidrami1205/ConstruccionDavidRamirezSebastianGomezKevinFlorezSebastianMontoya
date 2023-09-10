package modelo;

import java.util.HashMap;
import java.util.Map;

public class club {
    private Map<String, socios> socio;
    private int vipCount;
    

    public club() {
        this.socio = new HashMap<>(); 
        this.vipCount = 0;
    
    }

    public boolean afiliarSocio(String cedula, String nombre, String tipoSuscripcion) {
        if (socio.containsKey(cedula)) {
            return false; 
        }

        if (socio.size() >= 35) {
            return false; 
        }
        if (tipoSuscripcion.equalsIgnoreCase("VIP")) {
            if (vipCount >= 3) {
                return false;
                 
            }
            vipCount ++;
        }

            
            
        socios nuevoSocio = new socios(cedula, nombre, tipoSuscripcion); 
        socio.put(cedula, nuevoSocio);
        return true;
        }

    public boolean registrarPersonaAutorizada(String cedulaSocio, String nombreAutorizado) {
        socios socio = this.socio.get(cedulaSocio); 
        if (socio != null) {
            return socio.agregarPersonaAutorizada(nombreAutorizado);
        }
        return false; 
    }

    public boolean pagarFacturaPorConcepto(String cedulaSocio, String concepto) {
        socios socio = this.socio.get(cedulaSocio);
        if (socio != null) {
            for (facturas factura : socio.getFacturasSinPagar()) {
                if (factura.getConcepto().equals(concepto)) {
                    return socio.pagarFactura(factura);
                }
            }
        }
        return false; 
    }
    public boolean registrarConsumo(String cedulaSocio, String concepto, double valor, String generador) {
        socios socio = this.socio.get(cedulaSocio); 
        if (socio != null) {
            facturas factura = new facturas(concepto, valor, generador);
            socio.getFacturasSinPagar().add(factura);
            return true;
        }
        return false; 
    }

    public boolean aumentarFondos(String cedulaSocio, double monto) {
        socios socio = this.socio.get(cedulaSocio); 
        if (socio != null && (socio.getTipoSuscripcion().equals("VIP") && monto <= 5000000.0) ||
                (socio.getTipoSuscripcion().equals("Regular") && monto <= 1000000.0)) {
            socio.setFondosDisponibles(socio.getFondosDisponibles() + monto);
            return true;
        }
        return false; 
    }

    public boolean eliminarSocio(String cedulaSocio) {
        socios socio = this.socio.get(cedulaSocio); 
        if (socio != null) {
            if (socio.getTipoSuscripcion().equalsIgnoreCase("VIP") || !socio.getFacturasSinPagar().isEmpty() ||
                    socio.getPersonasAuto().size() > 1) {
                return false; 
            }
            this.socio.remove(cedulaSocio);
            return true;
        }
        return false; 
    }

    public double consultarTotalConsumos(String cedulaSocio) {
        socios socio = this.socio.get(cedulaSocio); 
        if (socio != null) {
            return socio.getTotalConsumos();
        }
        return -1; 
    }
}

