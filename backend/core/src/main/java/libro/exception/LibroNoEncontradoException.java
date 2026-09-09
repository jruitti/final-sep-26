package libro.exception;

import java.util.UUID;

public class LibroNoEncontradoException extends RuntimeException {
    public LibroNoEncontradoException(UUID id) {
        super("No se encontro ningun libro con el id: " + id);
    }
}
