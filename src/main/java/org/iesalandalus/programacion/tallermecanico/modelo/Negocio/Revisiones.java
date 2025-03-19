package org.iesalandalus.programacion.tallermecanico.modelo.Negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import javax.imageio.plugins.tiff.TIFFDirectory;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Revisiones {
    private final List<Revision> coleccionRevisiones;

    public Revisiones() {
        coleccionRevisiones = new ArrayList<>();
    }

    public List<Revision> get() {
        return new ArrayList<>(coleccionRevisiones);
    }

    public List<Revision> get(Cliente cliente) {
        List<Revision> revisionesCliente = new ArrayList<>();
        for (Revision revision : coleccionRevisiones) {
            if (revision.getCliente().equals(cliente)) {
                revisionesCliente.add(revision);
            }
        }
        return revisionesCliente;
    }

    public List<Revision> get(Vehiculo vehiculo) {
        List<Revision> revisionesVehiculo = new ArrayList<>();
        for (Revision revision : coleccionRevisiones) {
            if (revision.getVehiculo().equals(vehiculo)) {
                revisionesVehiculo.add(revision);
            }
        }
        return revisionesVehiculo;
    }

    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "No se puede insertar una revision nula.");

    }

    private void comprobarRevision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaRevision) throws TallerMecanicoExcepcion {
        for (Revision revision : coleccionRevisiones) {
            if (revision.estaCerrada()) {
                if (revision.getCliente().equals(cliente)) {
                    throw new TallerMecanicoExcepcion("El cliente tiene una revision en progreso");
                } else if (revision.getVehiculo().equals(vehiculo)) {
                    throw new TallerMecanicoExcepcion("El vehiculo esta actualmente en revision");
                }
            } else {
                if (revision.getCliente().equals(cliente) && !fechaRevision.isAfter(revision.getFechaFin())){
                    throw new TallerMecanicoExcepcion("El cliente tiene una revision posterior");
                } else if (revision.getVehiculo().equals(vehiculo) && !fechaRevision.isAfter(revision.getFechaFin())) {
                    throw new TallerMecanicoExcepcion("El vehiculo tiene una revision posterior.");
                }
            }
        }
    }

    public Revision añadirHoras(Revision revision, int horas) throws TallerMecanicoExcepcion {
        Revision revisionEcontrada = getRevision(revision);
        revisionEcontrada.anadirHoras(horas);
        return revisionEcontrada;
    }
    private Revision getRevision(Revision revision) throws TallerMecanicoExcepcion{
        Objects.requireNonNull(revision, "No puedo operar sobre una revision nula");
        Revision revisionEncontrada = buscar(revision);
        if (revisionEncontrada == null){
            throw  new TallerMecanicoExcepcion("No existe ninguna revision igual");
        }
        return revisionEncontrada;
    }
    public Revision anadirPrecioMaterial (Revision revision , float precioMaterial) throws  TallerMecanicoExcepcion{
        Revision revisionEncontrada = getRevision(revision);
        revisionEncontrada.anadirPrecioMaterial(precioMaterial);
        return  revisionEncontrada;
    }

    public Revision cerrar(Revision revision , LocalDate fechafin) throws TallerMecanicoExcepcion{
        Revision revisionEncontrada = getRevision(revision);
        revisionEncontrada.cerrar(fechafin);
        return revisionEncontrada;
    }

    public Revision buscar(Revision revision){
        Objects.requireNonNull(revision , "No se puede buscar una revision nula");
        int indice = coleccionRevisiones.indexOf(revision);
        return (indice == -1) ? null : coleccionRevisiones.get(indice);
    }

    public void borrar(Revision revision) throws TallerMecanicoExcepcion{
        Objects.requireNonNull(revision,"Nose peude copiar una revision nula");
        if (!coleccionRevisiones.contains(revision)){
            throw new TallerMecanicoExcepcion("No existe ninguna revision igual.");
        }
        coleccionRevisiones.remove(revision);
    }


}


