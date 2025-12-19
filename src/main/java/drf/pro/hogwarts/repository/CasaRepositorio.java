package drf.pro.hogwarts.repository;

import drf.pro.hogwarts.model.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CasaRepositorio extends JpaRepository<Casa, Long> {

    Optional<Casa> findByNombre(String nombre);
}
