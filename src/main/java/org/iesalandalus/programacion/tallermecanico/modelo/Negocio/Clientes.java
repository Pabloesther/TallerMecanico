package org.iesalandalus.programacion.tallermecanico.modelo.Negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Clientes {
    private final List<Cliente> coleccionCliente;

    public Clientes(){
        coleccionCliente = new ArrayList<>();
    }

    public List<Cliente> get() {
        return new ArrayList<>(coleccionCliente) ;
    }

    public void insertar (Cliente cliente) {
        Objects.requireNonNull(cliente,"No se puede insertar un cliente nulo.");
        if (coleccionCliente.contains(cliente)){
            throw new IllegalArgumentException("Ya existe un cliente con ese DNI.");
        }
        coleccionCliente.add(cliente);
    }
    public Cliente modificar (Cliente cliente,String nombre , String telefono ) throws TallerMecanicoExcepcion{
        Objects.requireNonNull(cliente,"No se puede modificar un cliente nulo");
        Cliente modificado = null;
        if (nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede ser blanco");
        }
        if (telefono.isBlank()){
            throw new IllegalArgumentException("El teléfono no puede ser blanco");
        }
        if (cliente == null || telefono == null){
            modificado = null;
        } else if (telefono == null) {
            modificado.setNombre(nombre);
            modificado = cliente;
        } else if (cliente == null) {
            modificado.setTelefono(telefono);
            modificado = cliente;
        } else  {
            modificado.setTelefono(telefono);
            modificado.setNombre(nombre);
            modificado = cliente;
        }
        return modificado;
    }

    public Cliente buscar (Cliente cliente){
        Objects.requireNonNull(cliente,"El cliente no puede ser nulo");
        Cliente buscado;
        if (!coleccionCliente.contains(cliente)){
            buscado = null;
        } else  {
         buscado =   coleccionCliente.get(coleccionCliente.indexOf(cliente));
        }
        return buscado;
    }

    public void borrar(Cliente cliente) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(cliente, "No se puede borrar un cliente nulo.");
        if (!coleccionCliente.contains(cliente)) {
            throw new TallerMecanicoExcepcion("No existe ningún cliente con ese DNI.");
        }
        coleccionCliente.remove(cliente);
    }
}


