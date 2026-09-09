package libro.exception;

public class TituloNuloException extends RuntimeException {
    public TituloNuloException() {
        super("El titulo no puede ser nulo");
    }
}
