package drf.pro.hogwarts.controller;

import drf.pro.hogwarts.dtos.response.CasaDTO;
import drf.pro.hogwarts.dtos.response.EstudianteDTO;
import drf.pro.hogwarts.model.Estudiante;
import drf.pro.hogwarts.service.CasaService;
import drf.pro.hogwarts.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService service;

    @PostMapping
    public ResponseEntity<Estudiante> crear(@RequestBody EstudianteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardarEstudiante(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody EstudianteDTO dto) {
        Estudiante usuarioActualizado = service.actualizarUsuario(id, dto);
        return ResponseEntity.ok(usuarioActualizado); // 200 OK
    }

}
