package principal;

import modelo.club;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        club Club = new club();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Menú ====");
            System.out.println("1. Afiliar socio");
            System.out.println("2. Registrar persona autorizada");
            System.out.println("3. Pagar factura");
            System.out.println("4. Registrar consumo");
            System.out.println("5. Aumentar fondos");
            System.out.println("6. Eliminar socio");
            System.out.println("7. Consultar total de consumos");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cédula del socio: ");
                    String cedulaSocio = scanner.nextLine();
                    System.out.print("Ingrese el nombre del socio: ");
                    String nombreSocio = scanner.nextLine();
                    System.out.print("Ingrese el tipo de suscripción (VIP/Regular): ");
                    String tipoSuscripcion = scanner.nextLine();

                    boolean afiliado = Club.afiliarSocio(cedulaSocio, nombreSocio, tipoSuscripcion);
                    if (afiliado) {
                        System.out.println("Socio afiliado con éxito.");
                    } else {
                        System.out.println("No se pudo afiliar al socio.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese la cédula del socio al que desea registrar la persona autorizada: ");
                    cedulaSocio = scanner.nextLine();
                    System.out.print("Ingrese el nombre de la persona autorizada: ");
                    String nombreAutorizado = scanner.nextLine();

                    boolean autorizado = Club.registrarPersonaAutorizada(cedulaSocio, nombreAutorizado);
                    if (autorizado) {
                        System.out.println("Persona autorizada registrada con éxito.");
                    } else {
                        System.out.println("No se pudo registrar la persona autorizada.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la cédula del socio que va a pagar la factura: ");
                    cedulaSocio = scanner.nextLine();
                    System.out.print("Ingrese el concepto de la factura que desea pagar: ");
                    String conceptoFactura = scanner.nextLine();

                    boolean pagada = Club.pagarFacturaPorConcepto(cedulaSocio, conceptoFactura);
                    if (pagada) {
                        System.out.println("Factura pagada con éxito.");
                    } else {
                        System.out.println("No se pudo pagar la factura.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese la cédula del socio que realizó el consumo: ");
                    cedulaSocio = scanner.nextLine();
                    System.out.print("Ingrese el concepto del consumo: ");
                    String concepto = scanner.nextLine();
                    System.out.print("Ingrese el valor del consumo: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del generador del consumo: ");
                    String generador = scanner.nextLine();

                    boolean registrado = Club.registrarConsumo(cedulaSocio, concepto, valor, generador);
                    if (registrado) {
                        System.out.println("Consumo registrado con éxito.");
                    } else {
                        System.out.println("No se pudo registrar el consumo.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese la cédula del socio al que desea aumentar los fondos: ");
                    cedulaSocio = scanner.nextLine();
                    System.out.print("Ingrese el monto a aumentar: ");
                    double monto = scanner.nextDouble();

                    boolean aumentado = Club.aumentarFondos(cedulaSocio, monto);
                    if (aumentado) {
                        System.out.println("Fondos aumentados con éxito.");
                    } else {
                        System.out.println("No se pudieron aumentar los fondos.");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese la cédula del socio que desea eliminar: ");
                    cedulaSocio = scanner.nextLine();

                    boolean eliminado = Club.eliminarSocio(cedulaSocio);
                    if (eliminado) {
                        System.out.println("Socio eliminado con éxito.");
                    } else {
                        System.out.println("No se pudo eliminar al socio.");
                        
                    }
                    break;

                case 7:
                    System.out.print("Ingrese la cédula del socio para consultar su total de consumos: ");
                    cedulaSocio = scanner.nextLine();

                    double totalConsumos = Club.consultarTotalConsumos(cedulaSocio);
                    if (totalConsumos >= 0) {
                        System.out.println("Total de consumos del socio: $" + totalConsumos);
                    } else {
                        System.out.println("No se encontró el socio con la cédula dada.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}    