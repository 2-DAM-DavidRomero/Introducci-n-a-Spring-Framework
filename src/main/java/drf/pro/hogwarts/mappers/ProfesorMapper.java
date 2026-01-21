package drf.pro.hogwarts.mappers;

import drf.pro.hogwarts.dtos.response.PorfesorDTO;
import drf.pro.hogwarts.model.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorMapper {
    public PorfesorDTO toDtoP(Profesor profesor){
        if (profesor == null){
            return null;
        }
        PorfesorDTO dto = new PorfesorDTO();
        dto.setId(profesor.getId_profesor());
        dto.setNombre(profesor.getNombre());
        dto.setAsignatura(profesor.getAsignatura().getNombre());
        dto.setFechaInicio(
                profesor.getFechaInicio() != null
                        ? profesor.getFechaInicio().toLocalDate()
                        : null
        );
        return dto;
    }
}
