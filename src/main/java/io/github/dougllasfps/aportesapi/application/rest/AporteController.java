package io.github.dougllasfps.aportesapi.application.rest;

import io.github.dougllasfps.aportesapi.domain.aportes.Aporte;
import io.github.dougllasfps.aportesapi.domain.aportes.AporteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/aportes")
@RequiredArgsConstructor
@Slf4j
class AporteController {

    private final AporteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aporte save(@RequestBody Aporte aporte){
        log.info("saving aporte {}", aporte);
        return service.saveOrUpdate(aporte);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("deleting aporte {}", id);
        service.deleteById(id);
    }

    @GetMapping
    public Iterable<Aporte> getByUsuarioAndAno(@RequestParam Long usuarioId, @RequestParam Integer ano){
        log.info("finding aportes by user {} and year {}", usuarioId, ano);
        return service.getByUsuarioId(usuarioId, ano);
    }
}
