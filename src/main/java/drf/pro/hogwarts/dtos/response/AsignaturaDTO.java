package drf.pro.hogwarts.dtos.response;

import lombok.Data;

@Data
public class AsignaturaDTO {
    private Long id;
    private String nombre;
    private String aula;
    private Boolean obligatoria;
    private String profesor;
}
