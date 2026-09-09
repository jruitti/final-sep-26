package libro.output;

import libro.modelo.Libro;

import java.util.UUID;

public interface BuscarLibroPorIdRepository {
    Libro buscar(UUID idLibro);
}
