package libro.exception;

public class LibroConIsbnExisteException extends RuntimeException {
    public LibroConIsbnExisteException(String isbn) {
        super("Ya existe un libro con el isbn: " + isbn);
    }
}
