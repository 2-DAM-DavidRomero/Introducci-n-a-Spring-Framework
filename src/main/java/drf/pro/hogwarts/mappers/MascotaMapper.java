package drf.pro.hogwarts.mappers;

import drf.pro.hogwarts.dtos.response.MascotaDTO;
import drf.pro.hogwarts.model.Mascota;

public class MascotaMapper {
    public MascotaDTO toDtoM(Mascota mascota){
        if (mascota==null){
            return null;
        }

        MascotaDTO dto = new MascotaDTO();
        dto.setId(mascota.getId_mascota());
        dto.setNombre(mascota.getNombre_mascota());
        dto.setEspecie(mascota.getEspecie());
        dto.setEstudiente(mascota.getEstudiante().getNombre());
        return dto;
    }
}
