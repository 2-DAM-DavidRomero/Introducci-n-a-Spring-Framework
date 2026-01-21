package drf.pro.hogwarts.dtos.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MascotaDTO {
    private Long id;
    private String nombre;
    private String especie;
    private String estudiente;
}
