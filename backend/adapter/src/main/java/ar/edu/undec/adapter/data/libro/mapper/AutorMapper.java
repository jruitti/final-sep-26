package ar.edu.undec.adapter.data.libro.mapper;

import ar.edu.undec.adapter.data.libro.model.AutorEntity;
import libro.modelo.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {
    public Autor toDomain(AutorEntity autorEntity){
        return Autor.factory(autorEntity.getNombre(), autorEntity.getNacionalidad());
    }

    public AutorEntity toEntity(Autor autor){
        return new AutorEntity(autor.getNombre(), autor.getNacionalidad());
    }
}
