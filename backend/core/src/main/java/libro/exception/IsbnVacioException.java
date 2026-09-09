package libro.exception;

public class IsbnVacioException extends RuntimeException {
    public IsbnVacioException() {
        super("El isbn no puede ser vacio");
    }
}
