package io.github.dougllasfps.aportesapi.domain.aportes.infraestructure;

import io.github.dougllasfps.aportesapi.domain.aportes.Aporte;
import io.github.dougllasfps.aportesapi.domain.aportes.AporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/aportes")
@RequiredArgsConstructor
class AporteController {

    private final AporteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aporte save(@RequestBody Aporte aporte){
        return service.saveOrUpdate(aporte);
    }

    @GetMapping
    public Iterable<Aporte> getByUsuarioAndAno(@RequestParam Long usuarioId, @RequestParam Integer ano){
        return service.getByUsuarioId(usuarioId, ano);
    }


}
