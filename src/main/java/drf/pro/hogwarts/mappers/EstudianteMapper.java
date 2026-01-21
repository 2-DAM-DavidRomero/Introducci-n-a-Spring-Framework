package drf.pro.hogwarts.mappers;

import drf.pro.hogwarts.dtos.response.EstudianteDTO;
import drf.pro.hogwarts.model.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {
    private final MascotaMapper mascotaMapper = new MascotaMapper();
    private final AsignaturaCalificacionMapper acMapper = new AsignaturaCalificacionMapper();


    public EstudianteDTO toDtoE(Estudiante estudiante){

        if (estudiante == null){
            return null;
        }
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setAnyoCurso(estudiante.getCurso());
        dto.setFechaNacimiento(estudiante.getFechaNacimiento().toLocalDate());
        dto.setCasa(estudiante.getCasa().getNombre());
        dto.setMascota(mascotaMapper.toDtoM(estudiante.getMascota()));
        dto.setAsignatura(
                estudiante.getAsignaturas()
                        .stream()
                        .map(acMapper::toDto) // EstudianteAsignatura -> AsignaturaCalificacionDTO
                        .toList()
        );

        return dto;
    }
}
