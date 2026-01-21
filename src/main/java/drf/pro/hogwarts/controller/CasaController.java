package drf.pro.hogwarts.controller;

import drf.pro.hogwarts.dtos.response.CasaDTO;
import drf.pro.hogwarts.model.Casa;
import drf.pro.hogwarts.service.CasaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/casas")
public class CasaController {

    private final CasaService casaService;

    public CasaController(CasaService casaService) {
        this.casaService = casaService;
    }

    @GetMapping
    public List<CasaDTO> getCasas() {
        return casaService.getAllCasas();
    }
}
