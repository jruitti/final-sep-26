package libro.output;

import libro.modelo.Libro;

public interface RegistrarLibroRepository {
    Libro guardar(Libro nuevoLibro);

    boolean existsByisbn(String isbn);
}
