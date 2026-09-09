package libro.output;

import libro.modelo.Libro;

import java.util.List;

public interface ListarLibrosRepository {
    List<Libro> listar();
}
