package drf.pro.hogwarts.mappers;

import drf.pro.hogwarts.dtos.response.AsignaturaCalificacionDTO;
import drf.pro.hogwarts.model.EstudianteAsignatura;

public class AsignaturaCalificacionMapper{

    public AsignaturaCalificacionDTO toDto(EstudianteAsignatura estAsig) {
        if (estAsig == null) return null;

        AsignaturaCalificacionDTO dto = new AsignaturaCalificacionDTO();
        dto.setAsignatura(
                estAsig.getAsignatura().getNombre()
        );
        dto.setCalificacion(estAsig.getCalificacion());

        return dto;
    }
}
