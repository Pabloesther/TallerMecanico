package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Consola {
    private Consola() {

    }

    public static void mostrarCabecera(String mensaje) {
        System.out.printf("%n%s%n", mensaje);
        System.out.printf("-".repeat(mensaje.length()).concat("%n%n"));
    }

    public void mostrarMenu() {
        mostrarCabecera("Gestion de un taller mecanico");
        for (Opcion opcion : Opcion.values()) {
            System.out.print(opcion);
        }
    }

    public static Opcion elegirOpcion() {
        Opcion opcion = null;
        do {
            try {
                opcion = Opcion.get(leerEntero("\nElige una opcion:"))
            } catch (IllegalArgumentException e) {
                System.out.printf("ERROR : %s%n",e.getMessage());
            }
        }while ( opcion ==null);
        return opcion;
    }
    private static int leerEntero(String mensaje){
        System.out.print(mensaje);
        return Entrada.entero();
    }

    private static float leerReal(String mensaje){
        System.out.print(mensaje);
        return Entrada.real();
    }

    private static String leerCadena(String mensaje){
        System.out.print(mensaje);
        return Entrada.cadena();
    }

    private static LocalDate leerFecha(String mensaje){
        LocalDate fecha;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(CADENA_FORMATO_FECHA);
        mensaje = String.format("%s (%s): ",mensaje , CADENA_FORMATO_FECHA);
        try{
            fecha = LocalDate.parse((leerCadena(mensaje)) , formatoFecha;
        }catch (DateTimeParseException e ){
            fecha = null;
        }
        return  fecha;
    }

    public  static Cliente leerCliente(){
        String nombre = leerCadena("Introduce el nombre");
        String dni = leerCadena("Introduce el DNI");
        String telefono = leerCadena("Introduce el teléfono");
        return  new Cliente(nombre,dni ,telefono);
    }

    public static  Cliente leerClienteDni(){
        return Cliente.get(leerCadena("Introduce el DNI: "));
    }

    public static  Cliente leerNuevoNombre(){
        return Cliente.get(leerCadena("Introduce el nombre: "));
    }

    public static  Cliente leerNuevoTelefono(){
        return Cliente.get(leerCadena("Introduce el teléfono: "));
    }

    public static Cliente leerVehiculo() {
        String marca = leerCadena("Introduce la marca: ");
        String modelo = leerCadena("Introduce el modelo");
        String matricula = leerCadena("Introduce la matricula");
        return new Vehiculo(marca , modelo , matricula);
    }

    public static  Vehiculo leerVehiculoMatricula() {
        return  Vehiculo.get(leerCadena("Introduce la matricula"));
    }

    public  static Revision leerRevision(){
        Cliente cliente = leerClienteDni();
        Vehiculo vehiculo = leerVehiculoMatricula();
        LocalDate fechaInnicio = leerFecha("Introduce la fecha de inicio");
        return new Revision (cliente,vehiculo,fechaInnicio);
    }

    public static int leerHoras(){
        return leerEntero("Introduce las horas a añacdir");
    }
    public static float  leerPrecioMaterial(){
        return leerReal("Introduce el precio del amteiral");

    }
    public static String leerfecha(){
        return leerfecha("Introduce la Fecha");
    }
}