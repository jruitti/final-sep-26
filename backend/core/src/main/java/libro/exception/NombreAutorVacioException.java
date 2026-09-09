package libro.exception;

public class NombreAutorVacioException extends RuntimeException {
    public NombreAutorVacioException() {
        super("El nombre del autor no puede estar vacio");
    }
}
