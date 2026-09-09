package libro.exception;

public class IsbnNuloException extends RuntimeException {
    public IsbnNuloException() {
        super("El isbn no puede ser nulo");
    }
}
