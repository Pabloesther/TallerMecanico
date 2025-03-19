package org.iesalandalus.programacion.tallermecanico.modelo.Negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vehiculos {
    private final List<Vehiculo> coleccionVehiculos;

    public Vehiculos(){
        coleccionVehiculos = new ArrayList<>();
    }

    public List<Vehiculo> get(){
        return new ArrayList<>(coleccionVehiculos);
    }

    public void insertar(Vehiculo vehiculo){
        Objects.requireNonNull(vehiculo , "No se puede insertar un Vehiculo nulo");
        if (coleccionVehiculos.contains(vehiculo)){
            throw new IllegalArgumentException("Ya existe un vehiculo con esa matricula");
        }
    }

    public Vehiculo buscar (Vehiculo vehiculo){
        Objects.requireNonNull(vehiculo, "No se puede insertar un vehiculo nulo");
        Vehiculo buscado;
        if (!coleccionVehiculos.contains(vehiculo)){
            buscado = null;
        } else  {
            buscado =   coleccionVehiculos.get(coleccionVehiculos.indexOf(vehiculo));
        }
      return buscado;
    }

    public void borrar (Vehiculo vehiculo){
        Objects.requireNonNull(vehiculo,"No se puede insertar un Vehiculo nulo");
        if (!coleccionVehiculos.contains(vehiculo)){
            throw new IllegalArgumentException("No existe un vehiculo con esa matricula");
        }else {
            coleccionVehiculos.remove(vehiculo);
        }

    }
}
