package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.controlador.Controlador;
import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.util.List;
import java.util.Objects;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador){
        Objects.requireNonNull(controlador , "ERROR : El controlador no puede ser nulo");
        this.controlador = controlador;
    }

    public  void comenzar(){
        Opcion opcion;
        do{
            Consola.mostrarMenu();
            opcion= Consola.elegirOpcion();
            ejecutar(opcion);
        }while (opcion != Opcion.SALIR );
        controlador.terminar();
    }

    public void terminar(){
        System.out.println("Se cierra");
    }

    private void ejecutar(Opcion opcion) {
        try (opcion) {
            switch (opcion) {
                case INSERTAR_CLIENTE -> insertarCliente();
                case INSERTAR_VEHICULO -> insertarVehiculo();
                case INSETAR_REVISION -> insertarRevision();
                case BUSCAR_CLIENTE -> buscarCliente();
                case BUSCAR_REVISION -> buscarRevision();
                case BUSCAR_VEHICULO -> buscarVehiculo();
                case MODIFICAR_CLIENTE -> modificarCliente();
                case ANADIR_HORAS_REVISION -> anadirHoras();
                case ANADIR_PRECIO_MATERIAL_REVISION -> anadirPreciMaterial();
                case CERRAR_REVISION -> cerrarRevision();
                case BORRAR_CLIENTE -> borrarCliente();
                case BORRAR_VEHICULO -> borrarVehiculo();
                case BORRAR_REVISION -> borrarRevision();
                case LISTAR_CLIENTES -> listarCliente();
                case LISTAR_VEHICULOS -> listarVehiculo();
                case LISTAR_REVISIONES -> listarRevisiones();
                case LISTAR_REVISIONES_CLIENTE -> listarRevisionesCliente();
                case LISTAR_REVISIONES_VEHICULO -> listarRevisionesVehiculo();
            }
        }catch (Exception e) {
            System.out.printf("ERROR: %s%n" , e.getMessage());
        }
    }

    private void insertarCliente() throws TallerMecanicoExcepcion {
        Consola.mostrarCabecera("Insertar Cliente");
        controlador.insertar(Consola.leerCliente());
        System.out.println("Cliente insertado correctamente");
    }

    private void insertarVehiculo() throws TallerMecanicoExcepcion{
        Consola.mostrarCabecera("Insertar Vehiculo");
        controlador.insertar(Consola.leerVehiculo());
        System.out.println("Vehiculo insertado correctamente");
    }

    private void insertarRevision() throws TallerMecanicoExcepcion{
        Consola.mostrarCabecera("Insetar Revision");
        controlador.insertar(Consola.leerRevision());
        System.out.println("Revision insertada correctamente");
    }

    private  void cerrarRevision() throws TallerMecanicoExcepcion{
        Consola.mostrarCabecera("Cerrar revision");
        controlador.cerrar(Consola.leerRevision() , Consola.leerfechaCierre());
        System.out.println("Revision cerrada correctamente.");
    }

    private void borrarCliente() throws TallerMecanicoExcepcion{
        Consola.mostrarCabecera("borrar Cliente");
        controlador.borrar(Consola.leerCliente() , Consola.leerfecha());
        System.out.println("Cliente borrado");
    }

    private void borrarVehiculo() throws TallerMecanicoExcepcion{
        Consola.mostrarCabecera("Borar cabecera");
        controlador.borrar(Consola.leerVehiculoMatricula());
        System.out.println("Vehiculo borrado correctamente");
    }

    private void borrarRevision() throws TallerMecanicoExcepcion{
        Consola.mostrarCabecera("Borrar Revision ");
        controlador.borrar(Consola.leerRevision());
        System.out.println("Revision borrada correctamente");
    }

    private void listarCliente () {
        Consola.mostrarCabecera("Listar Clientes");
        List<Cliente> clientes = controlador.getClientes();
        if (!Clientes.isEmpty()){
            for (Cliente cliente : clientes){
                System.out.println(cliente);
            }
        } else {
            System.out.println("No hay clientes que mostar.");
        }
        private void listarVehiculos() {
        }
    }

    private void listarVehiculo (){
        Consola.mostrarCabecera("Listar vehiculos.");
        List<Vehiculo> vehiculos = controlador.getVehiculos();
        if (!vehiculos.isEmpty()){
            for (Vehiculo vehiculo : vehiculos){
                System.out.println(vehiculo);
            }
        }else {
            System.out.println("No hay vehiculos que mostrar");
        }
    }

    private void listarRevisiones(){
        
    }
}

