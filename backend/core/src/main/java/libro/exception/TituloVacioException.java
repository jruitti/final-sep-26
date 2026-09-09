package libro.exception;

public class TituloVacioException extends RuntimeException {
    public TituloVacioException() {
        super("El titulo no puede estar vacio");
    }
}
