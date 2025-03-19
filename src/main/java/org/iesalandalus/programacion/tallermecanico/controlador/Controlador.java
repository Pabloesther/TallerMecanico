package org.iesalandalus.programacion.tallermecanico.controlador;

import org.iesalandalus.programacion.tallermecanico.modelo.Modelo;
import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.vista.Vista;

import java.time.LocalDate;
import java.util.Objects;

public class Controlador {
    private final Modelo modelo;
    private  final Vista vista;

    public Controlador(Modelo modelo , Vista vista ){
        Objects.requireNonNull(modelo , "ERROR : El modelo no puede ser nulo");
        Objects.requireNonNull(vista, "ERROR: La vista no puede ser nula");
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void comenzar(){
        modelo.comenzar();
        vista.comenzar();
    }

    public  void terminar() {
        modelo.terminar();
        vista.terminar();
    }
    public void insertar(Cliente cliente )throws TallerMecanicoExcepcion{
        modelo.insertar(cliente);
    }
    public void insertar(Modelo modelo) throws TallerMecanicoExcepcion{
        modelo.insertar(modelo);
    }
    public void insertar(Matricula matricula)throws TallerMecanicoExcepcion{
        modelo.insertar(matricula);
    }

    public Revision anadirPrecioMAterial (Revision revision , float precioMaterial) throws TallerMecanicoExcepcion{
        return  modelo.anadirPrecioMaterial(revision , precioMaterial);
    }

    public Revision cerrar(Revision revision, LocalDate fechaFin) throws TallerMecanicoExcepcion {
        return  modelo.cerrar(revision , fechaFin);
    }



}
