package io.github.dougllasfps.aportesapi.domain.aportes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AporteService {

    private final AporteRepository repository;

    @Transactional
    public Aporte saveOrUpdate(Aporte aporte){
        return repository.save(aporte);
    }

    @Transactional
    public void deleteById(Long aporteId){
        repository.deleteById(aporteId);
    }

    @Transactional
    public Iterable<Aporte> getByUsuarioId(Long idUsuario, Integer anoId){
        return repository.findByUsuarioidAndAno(idUsuario, anoId);
    }
}
