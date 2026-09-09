package libro.modelo;

import libro.exception.NacionalidadNulaException;
import libro.exception.NacionalidadVaciaException;
import libro.exception.NombreAutorNuloException;
import libro.exception.NombreAutorVacioException;

public class Autor {
    private String nombre;
    private String nacionalidad;

    public static Autor factory(String nombre, String nacionalidad){
        return new Autor(nombre, nacionalidad);
    }

    private static void validarParametros(String nombre, String nacionalidad){
        if(nombre==null)
            throw new NombreAutorNuloException();
        nombre=nombre.trim();
        if(nombre.isEmpty())
            throw new NombreAutorVacioException();
        if(nacionalidad == null)
            throw new NacionalidadNulaException();
        if(nacionalidad.isEmpty())
            throw new NacionalidadVaciaException();
    }
    private Autor(String nombre, String nacionalidad) {
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


}
