package drf.pro.hogwarts.service;

import drf.pro.hogwarts.dtos.response.CasaDTO;
import drf.pro.hogwarts.dtos.response.EstudianteDTO;
import drf.pro.hogwarts.mappers.CasaMapper;
import drf.pro.hogwarts.mappers.EstudianteMapper;
import drf.pro.hogwarts.model.Casa;
import drf.pro.hogwarts.model.Estudiante;
import drf.pro.hogwarts.model.Mascota;
import drf.pro.hogwarts.repository.CasaRepositorio;
import drf.pro.hogwarts.repository.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepositorio estudianteRepo;
    @Autowired
    private CasaRepositorio casaRepo;

    public Estudiante guardarEstudiante(EstudianteDTO dto) {
        Estudiante e = new Estudiante();
        e.setNombre(dto.getNombre());
        e.setApellido(dto.getApellido());
        e.setCurso(dto.getAnyoCurso());
        e.setFechaNacimiento(dto.getFechaNacimiento());

        // Buscamos la casa
        Casa casa = casaRepo.findById(dto.getCasaId())
                .orElseThrow(() -> new RuntimeException("Casa no encontrada"));
        e.setCasa(casa);

        // Mapeamos la mascota si viene en el JSON
        if (dto.getMascota() != null) {
            Mascota m = new Mascota();
            m.setNombre_mascota(dto.getMascota().getNombre());
            m.setEspecie(dto.getMascota().getEspecie());
            m.setEstudiante(e); // Relación bidireccional
            e.setMascota(m);
        }

        return estudianteRepo.save(e);
    }

    public Estudiante actualizarUsuario(long id, EstudianteDTO dto) {
        // 1. Buscamos el estudiante actual
        Estudiante estudiante = estudianteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));

        // REQUISITO: Fallar si se intenta modificar nombre o apellido
        // Si el DTO trae nombre/apellido y son distintos a los de la BD, lanzamos error
        if ((dto.getNombre() != null && !dto.getNombre().equals(estudiante.getNombre())) ||
                (dto.getApellido() != null && !dto.getApellido().equals(estudiante.getApellido()))) {
            throw new RuntimeException("No está permitido modificar el nombre o el apellido del estudiante.");
        }

        // 2. Actualizamos campos permitidos
        estudiante.setCurso(dto.getAnyoCurso());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());

        // REQUISITO: Reemplazar mascota si existe, o crearla si no
        if (dto.getMascota() != null) {
            Mascota mascotaParaAsignar;

            if (estudiante.getMascota() != null) {
                // Reutilizamos la existente para evitar duplicados en la BD (Reemplazo)
                mascotaParaAsignar = estudiante.getMascota();
            } else {
                // No tenía, creamos una nueva
                mascotaParaAsignar = new Mascota();
                mascotaParaAsignar.setEstudiante(estudiante);
            }

            mascotaParaAsignar.setNombre_mascota(dto.getMascota().getNombre());
            mascotaParaAsignar.setEspecie(dto.getMascota().getEspecie());

            estudiante.setMascota(mascotaParaAsignar);
        }

        // 3. Guardar cambios
        return estudianteRepo.save(estudiante);
    }
}
