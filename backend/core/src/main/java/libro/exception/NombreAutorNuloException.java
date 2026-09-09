package libro.exception;

public class NombreAutorNuloException extends RuntimeException {
    public NombreAutorNuloException() {
        super("El nombre del autor no puede ser nulo");
    }
}
