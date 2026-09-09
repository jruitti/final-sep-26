package libro.exception;

public class IdNuloException extends RuntimeException {
    public IdNuloException() {
        super("El id no puede ser nulo");
    }
}
