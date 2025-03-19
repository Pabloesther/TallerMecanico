package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.util.Objects;

public record Vehiculo (String modelo , String matricula , String marca) {
    private static final String ER_MARCA ="";
    private static final String ER_MATRICULA = "";

    public Vehiculo {
        validarModelo(modelo);
        validarMatricula(matricula);
        validarMarca(marca);
    }

    private void validarMatricula(String matricula) {
        Objects.requireNonNull(matricula, "La matricula no puede ser nula.");
        if (!matricula.matches(ER_MATRICULA)) {
            throw new IllegalArgumentException("La matricula no tiene un formato válido");
        }
    }
    private void validarModelo(String modelo) {
        Objects.requireNonNull(modelo , "El modelo no puede ser nulo");
        if (modelo.isBlank()){
            throw new IllegalArgumentException("El modelo no puede estar en blanco");
        }
    }

    private void validarMarca(String marca) {
        Objects.requireNonNull(marca, "La marca no puede ser nula");
        if (!marca.matches(ER_MARCA)) {
            throw new IllegalArgumentException("La marca no tiene formato valido.");
        }
    }

    public static Vehiculo get(String matricula){
        Objects.requireNonNull(matricula , "La matricula no puede ser nula");

        return new Vehiculo("Fort" , "Fiesta",matricula);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(marca, vehiculo.marca) && Objects.equals(modelo, vehiculo.modelo) && Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, matricula);
    }

    @Override
    public String toString() {
        return String.format("[marca=%s, modelo=%s, matricula=%s]", marca, modelo, matricula);
    }


}
