package factory;
import libro.exception.NacionalidadNulaException;
import libro.exception.NacionalidadVaciaException;
import libro.exception.NombreAutorNuloException;
import libro.exception.NombreAutorVacioException;
import libro.modelo.Autor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
class AutorTest {
    @Test
    @DisplayName("Datos validos, crear autor correctamente")
    void crearAutor(){
        Autor autor = Autor.factory("Robert C. Martin", "Estadounidense");
        assertEquals("Robert C. Martin", autor.getNombre());
        assertEquals("Estadounidense", autor.getNacionalidad());
    }

    @Test
    @DisplayName("Nombre nulo")
    void nombreNulo(){
        assertThrows(NombreAutorNuloException.class, () -> Autor.factory(null, "Estadounidense"));
    }
    @Test
    @DisplayName("Nombre vacio")
    void nombreVacio(){
        assertThrows(NombreAutorVacioException.class, () -> Autor.factory("", "Estadounidense"));
    }

    @Test
    @DisplayName("Nacionalidad nula")
    void nacionalidadNula(){
        assertThrows(NacionalidadNulaException.class, () -> Autor.factory("Robert C. Martin", null));
    }
    @Test
    @DisplayName("Nacionalidad vacia")
    void nacionalidadVacia(){
        assertThrows(NacionalidadVaciaException.class, () -> Autor.factory("Robert C. Martin", ""));
    }
}
