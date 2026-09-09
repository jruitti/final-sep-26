package libro.usecase;

import libro.exception.LibroNoEncontradoException;
import libro.input.BuscarLibroPorIdInput;
import libro.modelo.Libro;
import libro.output.BuscarLibroPorIdRepository;
import libro.output.ListarLibrosRepository;

import java.util.Optional;
import java.util.UUID;

public class BuscarLibroPorIdUseCase implements BuscarLibroPorIdInput {

    private final BuscarLibroPorIdRepository buscarLibroPorIdRepository;

    public BuscarLibroPorIdUseCase(BuscarLibroPorIdRepository buscarLibroPorIdRepository){
        this.buscarLibroPorIdRepository = buscarLibroPorIdRepository;
    }
    @Override
    public Libro buscarPorId(UUID idLibro) {
        Libro libroDevuelto = buscarLibroPorIdRepository.buscar(idLibro);

        if(libroDevuelto == null)
            throw new LibroNoEncontradoException(idLibro);
        return  libroDevuelto;
    }
}
