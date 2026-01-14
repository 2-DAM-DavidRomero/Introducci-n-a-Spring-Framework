//package drf.pro.hogwarts.controller;
//
//import drf.pro.hogwarts.model.Casa;
//import drf.pro.hogwarts.service.CasaService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/casas")
//public class CasaController {
//
//    private final CasaService casaService;
//
//    public CasaController(CasaService casaService) {
//        this.casaService = casaService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Casa>> getAllCasas() {
//        return ResponseEntity.ok(casaService.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Casa> getCasaById(@PathVariable Long id) {
//        return casaService.findById(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<Casa> createCasa(@RequestBody Casa casa) {
//        return new ResponseEntity<>(casaService.save(casa), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Casa> updateCasa(@PathVariable Long id, @RequestBody Casa casa) {
//        return casaService.findById(id)
//                .map(c -> {
//                    casa.setId(id);
//                    return ResponseEntity.ok(casaService.save(casa));
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCasa(@PathVariable Long id) {
//        casaService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//}

