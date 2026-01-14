package drf.pro.hogwarts.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "mascota")
public class Mascota {

    @Id
    @Column(name = "id_mascota")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mascota;

    @Column(name = "nombre_mascota")
    private String nombre_mascota;

    @Column(name = "especie")
    private String especie;

    @OneToOne
    @JoinColumn(name = "id_estudiante")
    @JsonManagedReference
    private Estudiante estudiante;



}
