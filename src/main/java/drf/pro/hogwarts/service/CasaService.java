//package drf.pro.hogwarts.service;
//
//import drf.pro.hogwarts.model.Casa;
//import drf.pro.hogwarts.repository.CasaRepositorio;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class CasaService {
//
//    private final CasaRepositorio casaRepository;
//
//    public CasaService(CasaRepositorio casaRepository) {
//        this.casaRepository = casaRepository;
//    }
//
//    public List<Casa> findAll() {
//        return casaRepository.findAll();
//    }
//
//    public Optional<Casa> findById(Long id) {
//        return casaRepository.findById(id);
//    }
//
//    public Optional<Casa> findByNombre(String nombre) {
//        return casaRepository.findByNombre(nombre);
//    }
//
//    public Casa save(Casa casa) {
//        return casaRepository.save(casa);
//    }
//
//    public void deleteById(Long id) {
//        casaRepository.deleteById(id);
//    }
//}
