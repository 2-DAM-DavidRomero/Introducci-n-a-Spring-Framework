package drf.pro.hogwarts.repository;

import drf.pro.hogwarts.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByCurso(int curso);

    List<Estudiante> findByCasaNombre(String nombreCasa);

    boolean existsByNombreAndApellido(String nombre, String apellido);

    Optional<Estudiante> findById(Long id);

}
