package drf.pro.hogwarts.service;

import drf.pro.hogwarts.model.Estudiante;
import drf.pro.hogwarts.repository.EstudianteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepositorio estudianteRepository;

    public EstudianteService(EstudianteRepositorio estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> findAll() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> findById(Long id) {
        return estudianteRepository.findById(id);
    }

    public List<Estudiante> findByCurso(int curso) {
        return estudianteRepository.findByCurso(curso);
    }

    public Estudiante save(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public void deleteById(Long id) {
        estudianteRepository.deleteById(id);
    }
}
