package drf.pro.hogwarts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "asignatura")
public class Asignatura {

    @Id
    @Column(name = "id_asignatura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignatura;

    @Column(name = "nombre")
    private String nombre;


    @Column(name = "aula")
    private String aula;

    @Column(name = "obligatoria")
    private Boolean obligatoria;

    @OneToMany(mappedBy = "asignatura")
    @JsonManagedReference
    private List<Profesor> profesores;


    @OneToMany(mappedBy = "asignatura")
    private List<EstudianteAsignatura> estudiantes;
}
