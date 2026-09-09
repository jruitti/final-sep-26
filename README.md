# Examen Final - Programación Avanzada I
### Ing. y Lic. en Sistemas
### Turno Septiembre 2026

### Objetivos
- Desarrollar endpoints que permitan el registro y consulta de la entidad Libro

### Tiempo
- 2 horas reloj

### Evaluación
- Se evaluará la versión del proyecto en el repositorio correspondiente, a la hora de finalización del examen, estimada para el día 10/09/2026 19:00
- El proyecto debe compilar sin errores en cualquier entorno de programación en el que se abra
- Todos los test unitarios deben pasar en verde

### Punto de partida
- Se proveerá el esquema de Backend en blanco, donde el alumno tendrá que crear test y código fuente que cubra la consigna.
- Prestar atención a los comentarios en el código

## Consigna
#### Módulo Biblioteca
_Se desea implementar un backend para un microservicio que permita registrar libros._

#### Restricciones:
- No pueden existir dos Libros con el mismo ISBN
- El id debe ser un UUID generado por la lógica de dominio, y no por estrategia de base de datos
- Todos los atributos de Libro son obligatorios
- La fecha de publicación del libro no puede ser superior a la actual
- El género del libro debe ser uno de los siguientes valores: FICCION - ENSAYO - TECNICO

#### Funcionalidad
- Crear Libro
  - Endpoint: POST http://localhost:8080/libros
  - RequestBody:
    ```json
    {
      "id": "7e8ad860-716d-4b86-9643-430870caefe7",
      "titulo": "Clean Code",
      "isbn": "978-0132350884",
      "fecha_publicacion": "2008-08-01T00:00:00.000Z",
      "genero": "TECNICO",
      "paginas": 464,
      "autor": "Robert C. Martin"
    }
    ```

- Buscar Libros
  - Endpoint: GET http://localhost:8080/libros

- Buscar Libro por id
  - Endpoint: GET http://localhost:8080/libros/{id}
  - Si el libro no existe, debe lanzarse una excepción personalizada (`LibroNoEncontradoException`) que resulte en una respuesta 404

#### Buenas prácticas y conceptos a considerar
- La nomenclatura de paquetes será en minúsculas
- La nomenclatura de clases será en UpperCamelCase
- La nomenclatura de métodos será en lowerCamelCase
- La organización de paquetes será por modelo->aspecto, tanto a nivel src/main como a nivel src/test. Ejemplo:
  ```
  libros
  └─ excepciones
  └─ modelo
  └─ repositorio
  └─ casodeuso
  ```
- Usar Excepciones personalizadas
- Se debe usar método factory/instancia para crear objetos
- Nomenclatura representativa de clases, métodos, etc.
- El Autor debe modelarse como un objeto propio (value object), no como campos sueltos en Libro