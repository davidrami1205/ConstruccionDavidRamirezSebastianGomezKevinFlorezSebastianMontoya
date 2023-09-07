package entregable1;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		club Club = new club();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("==== Menú ====");
            System.out.println("1. Afiliar socio");
            System.out.println("2. Registrar persona autorizada");
            // Agrega aquí las opciones para las demás funcionalidades

            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            
            switch (opcion) {
            case 1:
                System.out.print("Ingrese la cédula del socio: ");
                String cedula = scanner.nextLine();
                System.out.print("Ingrese el nombre del socio: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el tipo de suscripción (VIP/Regular): ");
                String t_suscripcion = scanner.nextLine();

                boolean afiliado = Club.afiliarsocios(cedula, nombre, t_suscripcion);
                if (afiliado) {
                    System.out.println("Socio afiliado con éxito.");
                } else {
                    System.out.println("No se pudo afiliar al socio.");
                }
                break;

            case 2:
                System.out.print("Ingrese la cédula del socio al que desea registrar la persona autorizada: ");
                cedula = scanner.nextLine();
                System.out.print("Ingrese el nombre de la persona autorizada: ");
                String personas_auto = scanner.nextLine();

                boolean autorizado = Club.registrarPersonaAutorizada(cedula, personas_auto);
                if (autorizado) {
                    System.out.println("Persona autorizada registrada con éxito.");
                } else {
                    System.out.println("No se pudo registrar la persona autorizada.");
                }
                break;

            // Agrega aquí los casos para las demás funcionalidades

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
