package libro.input;

import libro.modelo.Libro;

import java.util.UUID;

public interface BuscarLibroPorIdInput {
    Libro buscarPorId(UUID idLibro);
}
