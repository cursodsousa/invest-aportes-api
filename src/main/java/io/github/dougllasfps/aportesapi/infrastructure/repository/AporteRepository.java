package io.github.dougllasfps.aportesapi.infrastructure.repository;

import io.github.dougllasfps.aportesapi.domain.aportes.Aporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AporteRepository extends JpaRepository<Aporte, Long> {
    Iterable<Aporte> findByUsuarioidAndAno(Long usuarioId, Integer ano);
}
