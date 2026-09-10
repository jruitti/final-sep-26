package libro.modelo;

import libro.exception.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Libro {
    private final UUID id;
    private final String titulo;
    private final String isbn;
    private final LocalDateTime fechaDePublicacion;
    private final Genero genero;
    private final int paginas;
    private final Autor autor;

    public static Libro factory(String titulo, String isbn, LocalDateTime fechaDePublicacion, Genero genero, int paginas, Autor autor) {
        UUID idGenerado = UUID.randomUUID();
        validarParametros(idGenerado, titulo, isbn, fechaDePublicacion, genero, paginas, autor);
        return new Libro(idGenerado, titulo, isbn, fechaDePublicacion, genero, paginas, autor);
    }

    public static Libro reconstruir(UUID id, String titulo, String isbn, LocalDateTime fechaDePublicacion, Genero genero, int paginas, Autor autor) {

        validarParametros(id, titulo, isbn, fechaDePublicacion, genero, paginas, autor);
        return new Libro(id, titulo, isbn, fechaDePublicacion, genero, paginas, autor);
    }

    private Libro(UUID id, String titulo, String isbn, LocalDateTime fechaDePublicacion, Genero genero, int paginas, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.fechaDePublicacion = fechaDePublicacion;
        this.genero = genero;
        this.paginas = paginas;
        this.autor = autor;
    }

    private static void validarParametros(UUID id, String titulo, String isbn, LocalDateTime fechaDePublicacion, Genero genero, int paginas, Autor autor) {
        if (id == null)
            throw new IdNuloException();
        if (titulo == null)
            throw new TituloNuloException();
        titulo = titulo.trim();
        if (titulo.isEmpty())
            throw new TituloVacioException();
        if (isbn == null)
            throw new IsbnNuloException();
        isbn = isbn.trim();
        if(isbn.isEmpty())
            throw new IsbnVacioException();
        if(fechaDePublicacion == null)
            throw new FechaDePublicacionNulaException();
        if(fechaDePublicacion.isAfter(LocalDateTime.now()))
            throw new FechaDePublicacionPosteriorException();
        if(genero == null)
            throw new GeneroNuloException();
        if(autor == null)
            throw new AutorNuloException();
        if(paginas <= 0)
            throw new PaginasInvalidasException();
    }

    public UUID getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getIsbn() {
        return isbn;
    }
    public LocalDateTime getFechaDePublicacion() {
        return fechaDePublicacion;
    }
    public Genero getGenero() {
        return genero;
    }
    public int getPaginas() {
        return paginas;
    }
    public Autor getAutor() {
        return autor;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

/*
Restricciones:
No pueden existir dos Libros con el mismo ISBN
El id debe ser un UUID generado por la lógica de dominio, y no por estrategia de base de datos
Todos los atributos de Libro son obligatorios, incluidos los del Autor
La fecha de publicación del libro no puede ser superior a la actual
El género del libro debe ser uno de los siguientes valores: FICCION - ENSAYO - TECNICO
Si el género es TECNICO, el atributo paginas debe ser mayor o igual a 100
 */