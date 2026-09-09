package ar.edu.undec.adapter.data.libro.model;

import jakarta.persistence.*;
import libro.modelo.Autor;
import libro.modelo.Genero;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "libros")
public class LibroEntity {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "titulo")
    private String titulo;

    @Column(name = "isbn")
    private String isbn;
    @Column(name = "fecha_de_publicacion")
    private LocalDateTime fechaDePublicacion;
    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @Column(name = "paginas")
    private int paginas;
    @Column(name = "autor")
    @ManyToOne(fetch = FetchType.LAZY)
    private AutorEntity autor;

    public LibroEntity() {
    }

    public LibroEntity(UUID id, String titulo, String isbn, LocalDateTime fechaDePublicacion, Genero genero, int paginas, AutorEntity autor) {
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getFechaDePublicacion() {
        return fechaDePublicacion;
    }

    public void setFechaDePublicacion(LocalDateTime fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public AutorEntity getAutor() {
        return autor;
    }

    public void setAutor(AutorEntity autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LibroEntity that = (LibroEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
