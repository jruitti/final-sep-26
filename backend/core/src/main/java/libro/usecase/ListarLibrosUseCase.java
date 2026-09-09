package libro.usecase;

import libro.input.ListarLibrosInput;
import libro.modelo.Libro;
import libro.output.ListarLibrosRepository;

import java.util.List;

public class ListarLibrosUseCase implements ListarLibrosInput {

    private final ListarLibrosRepository listarLibrosRepository;

    public ListarLibrosUseCase(ListarLibrosRepository listarLibrosRepository){
        this.listarLibrosRepository = listarLibrosRepository;
    }

    @Override
    public List<Libro> listar() {
        return listarLibrosRepository.listar();
    }
}
