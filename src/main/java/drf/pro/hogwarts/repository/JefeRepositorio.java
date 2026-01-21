package drf.pro.hogwarts.repository;

import drf.pro.hogwarts.model.Profesor;
import drf.pro.hogwarts.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JefeRepositorio extends JpaRepository<Profesor, Long> {
}
