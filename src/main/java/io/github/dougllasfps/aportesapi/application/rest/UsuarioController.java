package io.github.dougllasfps.aportesapi.application.rest;

import io.github.dougllasfps.aportesapi.application.dto.Credentials;
import io.github.dougllasfps.aportesapi.application.dto.UsuarioResponse;
import io.github.dougllasfps.aportesapi.domain.usuarios.Usuario;
import io.github.dougllasfps.aportesapi.domain.usuarios.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse register(@RequestBody Usuario usuario){
        usuario = service.saveOrUpdate(usuario);
        return UsuarioResponse.builder()
                .nome(usuario.getNome())
                .id(usuario.getId())
                .build();
    }

    @PostMapping("/auth")
    public UsuarioResponse auth(@RequestBody Credentials credentials){
        return service
                .auth(credentials.getEmail(), credentials.getSenha())
                .map(u -> UsuarioResponse.builder().id(u.getId()).nome(u.getNome()).build())
                .orElse(null);
    }
}
