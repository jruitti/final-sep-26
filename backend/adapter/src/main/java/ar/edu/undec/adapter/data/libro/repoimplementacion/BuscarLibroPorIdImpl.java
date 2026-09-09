package ar.edu.undec.adapter.data.libro.repoimplementacion;

import ar.edu.undec.adapter.data.libro.crud.LibroRepositoryJpa;
import ar.edu.undec.adapter.data.libro.mapper.LibroMapper;
import libro.input.BuscarLibroPorIdInput;
import libro.modelo.Libro;
import libro.output.BuscarLibroPorIdRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Repository
public class BuscarLibroPorIdImpl implements BuscarLibroPorIdRepository {

    private LibroRepositoryJpa librorepositoryJpa;
    private LibroMapper libroMapper;

    public BuscarLibroPorIdImpl(LibroRepositoryJpa libroRepositoryJpa, LibroMapper libroMapper){
        this.librorepositoryJpa = libroRepositoryJpa;
        this.libroMapper = libroMapper;
    }

    @Override
    public Libro buscar(UUID idLibro) {
        return libroMapper.toDomain(librorepositoryJpa.findByid(idLibro));
    }
}
