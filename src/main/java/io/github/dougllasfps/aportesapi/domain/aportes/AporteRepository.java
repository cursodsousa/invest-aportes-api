package io.github.dougllasfps.aportesapi.domain.aportes;

import org.springframework.data.jpa.repository.JpaRepository;

interface AporteRepository extends JpaRepository<Aporte, Long> {
    Iterable<Aporte> findByUsuarioidAndAno(Long usuarioId, Integer ano);
}
