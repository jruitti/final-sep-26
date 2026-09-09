package libro.exception;

public class GeneroNuloException extends RuntimeException {
    public GeneroNuloException() {
        super("El genero no puede ser nulo");
    }
}
