package libro.usecase;

import libro.exception.LibroConIsbnExisteException;
import libro.input.RegistrarLibroInput;
import libro.modelo.Libro;
import libro.output.RegistrarLibroRepository;

public class RegistrarLibroUseCase implements RegistrarLibroInput {
    private RegistrarLibroRepository registrarLibroRepository;

    public RegistrarLibroUseCase(RegistrarLibroRepository registrarLibroRepository){
        this.registrarLibroRepository = registrarLibroRepository;
    }
    @Override
    public Libro registrar(Libro libroNuevo) {
        if (registrarLibroRepository.existsByisbn(libroNuevo.getIsbn()))
            throw new LibroConIsbnExisteException(libroNuevo.getIsbn());

        return registrarLibroRepository.guardar(libroNuevo);
    }
}
