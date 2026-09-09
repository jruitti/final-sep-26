package libro.exception;

public class AutorNuloException extends RuntimeException {
    public AutorNuloException() {
        super("El autor no puede ser nulo");
    }
}
