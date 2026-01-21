package drf.pro.hogwarts.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante_asignatura")
public class EstudianteAsignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura asignatura;

    private Double calificacion;
}
