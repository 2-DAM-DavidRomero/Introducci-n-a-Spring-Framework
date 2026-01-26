package drf.pro.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante_asignatura")
public class EstudianteAsignatura {

    @EmbeddedId
    private EstudianteAsignaturaId id; // Ya no hay "private Long id"

    @ManyToOne
    @MapsId("idEstudiante") // Conecta el ID embebido con esta relación
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @MapsId("idAsignatura") // Conecta el ID embebido con esta relación
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    private Double calificacion;
}