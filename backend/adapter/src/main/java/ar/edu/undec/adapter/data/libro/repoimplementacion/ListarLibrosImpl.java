package ar.edu.undec.adapter.data.libro.repoimplementacion;

import ar.edu.undec.adapter.data.libro.crud.LibroRepositoryJpa;
import ar.edu.undec.adapter.data.libro.mapper.LibroMapper;
import libro.input.ListarLibrosInput;
import libro.modelo.Libro;
import libro.output.ListarLibrosRepository;

import java.util.List;

public class ListarLibrosImpl implements ListarLibrosRepository {
    private LibroRepositoryJpa librorepositoryJpa;
    private LibroMapper libroMapper;

    public ListarLibrosImpl(LibroRepositoryJpa libroRepositoryJpa, LibroMapper libroMapper){
        this.librorepositoryJpa = libroRepositoryJpa;
        this.libroMapper = libroMapper;
    }
    @Override
    public List<Libro> listar() {
        return librorepositoryJpa.findAll()
                .stream()
                .map(libroMapper::toDomain)
                .toList();
    }
}
