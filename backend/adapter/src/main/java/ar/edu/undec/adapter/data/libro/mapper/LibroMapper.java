package ar.edu.undec.adapter.data.libro.mapper;

import ar.edu.undec.adapter.data.libro.model.LibroEntity;
import libro.modelo.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    private AutorMapper autorMapper;

    public LibroMapper(AutorMapper autorMapper){
        this.autorMapper = autorMapper;
    }

    public Libro toDomain(LibroEntity libroEntity){
        return Libro.reconstruir(
                libroEntity.getId(),
                libroEntity.getTitulo(),
                libroEntity.getIsbn(),
                libroEntity.getFechaDePublicacion(),
                libroEntity.getGenero(),
                libroEntity.getPaginas(),
                autorMapper.toDomain(libroEntity.getAutor()));
    }
    public LibroEntity toEntity(Libro libro){
        return new LibroEntity(
                libro.getId(),
                libro.getTitulo(),
                libro.getIsbn(),
                libro.getFechaDePublicacion(),
                libro.getGenero(),
                libro.getPaginas(),
                autorMapper.toEntity(libro.getAutor())
        );
    }
}
