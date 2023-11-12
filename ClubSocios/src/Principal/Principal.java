package Principal;

import java.util.Scanner;
import ModeloImp.Club;
import ModeloImp.Factura;
import ModeloImp.Persona;
import ModeloImp.PersonaAutorizada;
import ModeloImp.Socio;
import Controladores.ControladorPersonasBusiness;
import Controladores.ControladorPersonasInput;
import ControladoresImp.ControladorBusinessImp;
import ControladoresImp.ControladorInputImp;

public class Principal {

	public static void main(String[] args) {
		Club club = new Club();
		Scanner lector = new Scanner(System.in);
		boolean ejecucion = true;
			while (ejecucion) {
				try {
					System.out.println("Seleccione una opcion: ");
					System.out.println("1. Registrar un Socio ");
					System.out.println("2. Registrar una Persona Autorizada ");
					System.out.println("3. Pagar una Factura ");
					System.out.println("4. Registrar un Consumo en la cuenta de un Socio ");
					System.out.println("4. Aumentar fondos de la cuenta de un Socio ");
					System.out.println("6. Salir ");
					int opcion = lector.nextInt();
					switch (opcion) {
						case 1:
							ControladorPersonasInput controladorInput = new ControladorInputImp();
							ControladorPersonasBusiness controladorBusiness = new ControladorBusinessImp();
							System.out.println("Ingrese el nombre del Socio: ");
							String nombre = controladorInput.validarNombre(lector.next());
							System.out.println("Ingrese la cedula del Socio: ");
							int cedula = controladorInput.validarCedula(lector.next());
							controladorBusiness.validadorCedulaSocio(club, cedula);
							System.out.println("Ingrese el Tipo de Suscripción del Socio: ");
							String tipo_sus = controladorInput.validarSuscripcion(lector.next());
							Persona persona = new Persona();
							Socio socio = new Socio();
							persona.setNombre(nombre);
							persona.setCedula(cedula);
							socio.setPersona(persona);
							socio.setT_suscripción(tipo_sus);
							club.getSocios().add(socio);
							System.out.println("Se agrega al Socio con Datos: " + socio.mostrarDatos());						
							break;
						case 2:
							System.out.println("Ingrese la cedual del Socio: ");
							int cedulaSocio = lector.nextInt();
							System.out.println("Ingrese la cedula de la Persona Autorizada: ");
							int cedulaAutorizado = lector.nextInt();
							System.out.println("Ingrese el nombre de la Persona Autorizada: ");
							String nombreAutorizado = lector.next();
							Socio socioAuto = club.buscarSocioPorCedula(cedulaSocio);
							Persona personaAuto = new Persona();
							PersonaAutorizada Autorizado = new PersonaAutorizada();
							personaAuto.setCedula(cedulaAutorizado);
							personaAuto.setNombre(nombreAutorizado);
							Autorizado.setPersona(personaAuto);
							socioAuto.getP_autorizada().add(Autorizado);
							club.getP_autorizada().add(Autorizado);
							System.out.println("Se agrega a la Persona Autorizada con Datos: " + "\n Cedula Socio: "
									+ socioAuto.getPersona().getCedula() + Autorizado.mostrarDatos());
							break;
						case 3:
							System.out.println("Ingrese la cédula del Socio: ");
						    int cedulaSocioPago = lector.nextInt();
						    Socio socioPago = club.buscarSocioPorCedula(cedulaSocioPago);
						    	if (socioPago != null) {
						    		System.out.println("Facturas pendientes para el Socio: ");
						    		System.out.println("Ingrese el número de la factura a pagar: ");
						    		int numeroFactura = lector.nextInt();
						    		Factura facturaSeleccionada = club.buscarFacturaPorNumero(numeroFactura);
						    		if (facturaSeleccionada != null) {
						    			if (facturaSeleccionada.pagarFactura(socioPago)) {
						    				System.out.println("Factura pagada con éxito.");
						    				} else {
						    					System.out.println("Error: Fondos insuficientes para pagar la factura.");
						    				}
						    			} else {System.out.println("Error: Factura no encontrada.");
						    			}
						    		} else {
						    			System.out.println("Socio no encontrado.");
						    		}
						    	break;
						case 4:			
							System.out.println("Seleccione una opcion: ");
							System.out.println("1. Registrar factura Socio ");
							System.out.println("2. Registrar factura Persona Autorizada ");
							int opcion2 = lector.nextInt();
								switch(opcion2) {
									case 1:
										System.out.println("Ingrese la cedula del socio");
										int cedulaSocioFactu = lector.nextInt();
										System.out.println("Ingrese le Concepto de la factura: ");
										int conceptoFactura = lector.nextInt();
										System.out.println("Ingrese el valor de la factura: ");
										int valorFactu = lector.nextInt();
										Socio  socioFactu = club.buscarSocioPorCedula(cedulaSocioFactu);
										
										break;
									case 2:
										break;	
								}
							break;
						case 5:
							break;
						case 6:
							ejecucion = false;
							lector.close();
							break;	
						default: {
							System.out.println("Opcion no valida ");
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
			}
		}
	}		
}


