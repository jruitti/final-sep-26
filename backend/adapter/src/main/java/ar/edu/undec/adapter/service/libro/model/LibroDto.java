package ar.edu.undec.adapter.service.libro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import libro.modelo.Autor;
import libro.modelo.Genero;

import java.time.LocalDateTime;
import java.util.UUID;

public class LibroDto {
    private UUID id;
    private String titulo;
    private String isbn;
    private LocalDateTime fechaDePublicacion;
    private Genero genero;
    private int paginas;
    private Autor autor;

    public LibroDto() {
    }

    public LibroDto(UUID id, String titulo, String isbn, LocalDateTime fechaDePublicacion, Genero genero, int paginas, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.fechaDePublicacion = fechaDePublicacion;
        this.genero = genero;
        this.paginas = paginas;
        this.autor = autor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
