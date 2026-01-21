package drf.pro.hogwarts.mappers;

import drf.pro.hogwarts.dtos.response.CasaDTO;
import drf.pro.hogwarts.model.Casa;
import drf.pro.hogwarts.model.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class CasaMapper {
    private final ProfesorMapper profesorMapper = new ProfesorMapper();

    public CasaDTO toDtoC(Casa casa) {
        if (casa == null){
            return null;
        }
        CasaDTO dto = new CasaDTO();
        dto.setId(casa.getId());
        dto.setNombre(casa.getNombre());
        dto.setFundador(casa.getFundador());
        dto.setFantasma(casa.getFantasma());
        dto.setJefe(profesorMapper.toDtoP(casa.getJefe()));
        dto.setEstudiantes(casa.getEstudiante()
                .stream()
                .map(Estudiante::getNombre) // o el campo que quieras
                .toList());
        return dto;
    }
}
