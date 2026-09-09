package libro.exception;

public class FechaDePublicacionNulaException extends RuntimeException {
    public FechaDePublicacionNulaException() {
        super("La fecha de publicacion no puede ser nula");
    }
}
