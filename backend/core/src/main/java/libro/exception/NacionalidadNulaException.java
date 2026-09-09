package libro.exception;

public class NacionalidadNulaException extends RuntimeException {
    public NacionalidadNulaException() {
        super("La nacionalidad no puede ser nula");
    }
}
