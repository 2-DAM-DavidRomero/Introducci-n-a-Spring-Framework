package drf.pro.hogwarts.dtos.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Data
public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private int anyoCurso;
    private LocalDate fechaNacimiento;
    private Long casaId;
    private MascotaDTO mascota;
    private List<AsignaturaCalificacionDTO> asignatura;
}
