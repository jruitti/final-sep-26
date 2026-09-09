package ar.edu.undec.adapter.service.libro.controller;

import libro.input.ListarLibrosInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libros")
public class ListarLibrosController {
    private ListarLibrosInput listarLibrosInput;

    public ListarLibrosController(ListarLibrosInput listarLibrosInput){
        this.listarLibrosInput = listarLibrosInput;
    }

    @GetMapping
    public ResponseEntity<?> listar(){

         return ResponseEntity.ok(listarLibrosInput.listar()
                 .stream()
                 .map(mapperLibro::toDto)
                 .toList());
    }
}
