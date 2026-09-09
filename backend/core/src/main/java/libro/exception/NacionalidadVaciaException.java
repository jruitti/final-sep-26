package libro.exception;

public class NacionalidadVaciaException extends RuntimeException {
    public NacionalidadVaciaException() {
        super("La nacionalidad no puede estar vacia");
    }
}
