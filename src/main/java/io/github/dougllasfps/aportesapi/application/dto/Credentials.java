package io.github.dougllasfps.aportesapi.application.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Credentials {
    private String email;
    private String senha;
}
