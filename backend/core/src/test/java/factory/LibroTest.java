package factory;
import libro.exception.*;
import libro.modelo.Autor;
import libro.modelo.Genero;
import libro.modelo.Libro;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
class LibroTest {
    private Autor autorValido;
    private String tituloValido;
    private String isbnValido;
    private LocalDateTime fechaValida;
    @BeforeEach
    void setUp(){
        autorValido = Autor.factory("Robert C. Martin", "Estadounidense");
        tituloValido = "Clean Code";
        isbnValido = "978-0132350884";
        fechaValida = LocalDateTime.of(2008,8,1,00,00,000);
    }

    @Test
    @DisplayName("Datos validos, registrar libro correctamente")
    void registrarLibro(){
        Libro libro = Libro.factory(tituloValido,isbnValido,fechaValida, Genero.TECNICO, 464, autorValido);

        assertEquals("Robert C. Martin", autorValido.getNombre());
        assertEquals("Estadounidense", autorValido.getNacionalidad());
        assertEquals("Clean Code", libro.getTitulo());
        assertEquals("978-0132350884", libro.getIsbn());
        assertEquals(Genero.TECNICO, libro.getGenero());
        assertEquals(464, libro.getPaginas());
        assertEquals(autorValido, libro.getAutor());
    }
    @Test
    @DisplayName("UUID nulo")
    void idValido() {
        Libro libro = Libro.factory(tituloValido,isbnValido,fechaValida, Genero.TECNICO, 464, autorValido);
        assertNotNull(libro.getId());
    }
    @Test
    @DisplayName("Titulo nulo")
    void tituloNulo(){
        assertThrows(TituloNuloException.class, () -> Libro.factory(null, isbnValido, fechaValida,Genero.TECNICO,464, autorValido));
    }
    @Test
    @DisplayName("Titulo vacio")
    void tituloVacio(){
        assertThrows(TituloVacioException.class, () -> Libro.factory("", isbnValido, fechaValida,Genero.TECNICO,464, autorValido));
    }

    @Test
    @DisplayName("Isbn nulo")
    void isbnNulo(){
        assertThrows(IsbnNuloException.class, () -> Libro.factory(tituloValido, null, fechaValida,Genero.TECNICO,464, autorValido));
    }

    @Test
    @DisplayName("Isbn vacio")
    void isbnVacio(){
        assertThrows(IsbnVacioException.class, () -> Libro.factory(tituloValido, "", fechaValida,Genero.TECNICO,464, autorValido));
    }

    @Test
    @DisplayName("Fecha nula")
    void fechaNula(){
        assertThrows(FechaDePublicacionNulaException.class, () -> Libro.factory(tituloValido, isbnValido, null,Genero.TECNICO,464, autorValido));
    }
    @Test
    @DisplayName("Fecha futura")
    void fechaFutura(){
        assertThrows(FechaDePublicacionPosteriorException.class, () -> Libro.factory(tituloValido, isbnValido, LocalDateTime.of(2028,8,1,00,00,000),Genero.TECNICO,464, autorValido));
    }

    @Test
    @DisplayName("Genero nulo")
    void generoNulo(){
        assertThrows(GeneroNuloException.class, () -> Libro.factory(tituloValido, isbnValido, fechaValida,null,464, autorValido));
    }
    @Test
    @DisplayName("Autor nulo")
    void autorNulo(){
        assertThrows(AutorNuloException.class, () -> Libro.factory(tituloValido, isbnValido, fechaValida,Genero.TECNICO,464, null));
    }
}
