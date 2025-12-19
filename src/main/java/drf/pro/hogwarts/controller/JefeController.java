package drf.pro.hogwarts.controller;

import drf.pro.hogwarts.model.Profesor;
import drf.pro.hogwarts.model.Profesor;
import drf.pro.hogwarts.service.JefeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jefes")
public class JefeController {

    private final JefeService jefeService;

    public JefeController(JefeService jefeService) {
        this.jefeService = jefeService;
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> getAllJefes() {
        return ResponseEntity.ok(jefeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> getJefeById(@PathVariable Long id) {
        return jefeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Profesor> createJefe(@RequestBody Profesor jefe) {
        return new ResponseEntity<>(jefeService.save(jefe), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> updateJefe(@PathVariable Long id, @RequestBody Profesor jefe) {
        return jefeService.findById(id)
                .map(j -> {
                    jefe.setId_profesor(id);
                    return ResponseEntity.ok(jefeService.save(jefe));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJefe(@PathVariable Long id) {
        jefeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
