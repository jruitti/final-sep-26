package libro.modelo;

import libro.exception.NacionalidadNulaException;
import libro.exception.NacionalidadVaciaException;
import libro.exception.NombreAutorNuloException;
import libro.exception.NombreAutorVacioException;

public class Autor {
    private final String nombre;
    private final String nacionalidad;

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
    public static Autor factory(String nombre, String nacionalidad){
        validarParametros(nombre, nacionalidad);
        return new Autor(nombre, nacionalidad);
    }

    private Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    public String getNombre() {
        return nombre;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
}
