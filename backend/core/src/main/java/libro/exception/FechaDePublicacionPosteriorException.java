package libro.exception;

public class FechaDePublicacionPosteriorException extends RuntimeException {
    public FechaDePublicacionPosteriorException() {
        super("La fecha de publicacion no puede ser posterior a la actual");
    }
}
