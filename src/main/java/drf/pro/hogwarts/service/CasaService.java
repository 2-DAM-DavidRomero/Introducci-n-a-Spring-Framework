package drf.pro.hogwarts.service;

import drf.pro.hogwarts.dtos.response.CasaDTO;
import drf.pro.hogwarts.mappers.CasaMapper;
import drf.pro.hogwarts.model.Casa;
import drf.pro.hogwarts.repository.CasaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasaService {

    private final CasaRepositorio casaRepository;
    private final CasaMapper casaMapper;


    public CasaService(CasaRepositorio casaRepository, CasaMapper casaMapper) {
        this.casaRepository = casaRepository;
        this.casaMapper = casaMapper;
    }

    public List<CasaDTO> getAllCasas() {
        return casaRepository.findAll()
                .stream()
                .map(casaMapper::toDtoC)
                .toList();
    }
}

