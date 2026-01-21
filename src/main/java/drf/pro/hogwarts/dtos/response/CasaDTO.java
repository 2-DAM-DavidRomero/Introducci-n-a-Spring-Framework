package drf.pro.hogwarts.dtos.response;

import lombok.Data;

import java.util.List;

@Data
public class CasaDTO {
    private Long id;
    private String nombre;
    private String fundador;
    private String fantasma;
    private PorfesorDTO jefe;
    private List<String> estudiantes;
}
