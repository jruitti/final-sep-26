package ar.edu.undec.adapter.data.libro.crud;

import ar.edu.undec.adapter.data.libro.model.LibroEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LibroRepositoryJpa extends JpaRepository<LibroEntity, UUID> {
    LibroEntity findByid(UUID idLibro);
    List<LibroEntity> findAll();
}
