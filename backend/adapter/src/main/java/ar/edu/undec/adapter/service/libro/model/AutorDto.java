package ar.edu.undec.adapter.service.libro.model;

import java.util.Objects;

public class AutorDto {
    private String nombre;
    private String nacionalidad;

    public AutorDto() {
    }

    public AutorDto(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AutorDto autorDto = (AutorDto) o;
        return Objects.equals(nombre, autorDto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
