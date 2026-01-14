//package drf.pro.hogwarts.service;
//
//import drf.pro.hogwarts.model.Profesor;
//import drf.pro.hogwarts.model.Profesor;
//import drf.pro.hogwarts.repository.JefeRepositorio;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class JefeService {
//
//    private final JefeRepositorio jefeRepository;
//
//    public JefeService(JefeRepositorio jefeRepository) {
//        this.jefeRepository = jefeRepository;
//    }
//
//    public List<Profesor> findAll() {
//        return jefeRepository.findAll();
//    }
//
//    public Optional<Profesor> findById(Long id) {
//        return jefeRepository.findById(id);
//    }
//
//    public Profesor save(Profesor jefe) {
//        return jefeRepository.save(jefe);
//    }
//
//    public void deleteById(Long id) {
//        jefeRepository.deleteById(id);
//    }
//}
