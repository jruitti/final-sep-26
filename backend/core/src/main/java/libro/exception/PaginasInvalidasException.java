package libro.exception;

public class PaginasInvalidasException extends RuntimeException {
    public PaginasInvalidasException() {
        super("El numero de paginas no puede ser negativo ni cero");
    }
}
