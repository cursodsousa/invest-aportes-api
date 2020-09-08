package io.github.dougllasfps.aportesapi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@Builder
@AllArgsConstructor@NoArgsConstructor
public class UsuarioResponse {
    private Long id;
    private String nome;
}
