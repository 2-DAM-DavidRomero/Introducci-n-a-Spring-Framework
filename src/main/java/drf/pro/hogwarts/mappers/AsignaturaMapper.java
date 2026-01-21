package drf.pro.hogwarts.mappers;

import drf.pro.hogwarts.dtos.response.AsignaturaDTO;
import drf.pro.hogwarts.model.Asignatura;
import org.springframework.stereotype.Component;

@Component
public class AsignaturaMapper {

    public AsignaturaDTO toDtoA(Asignatura asignatura) {
        if (asignatura == null) return null;

        AsignaturaDTO dto = new AsignaturaDTO();
        dto.setId(asignatura.getId_asignatura());
        dto.setNombre(asignatura.getNombre());
        dto.setAula(asignatura.getAula());
        dto.setObligatoria(asignatura.getObligatoria());

        dto.setProfesor(
                asignatura.getProfesores() != null && !asignatura.getProfesores().isEmpty()
                        ? asignatura.getProfesores().get(0).getNombre()
                        : null
        );

        return dto;
    }
}
