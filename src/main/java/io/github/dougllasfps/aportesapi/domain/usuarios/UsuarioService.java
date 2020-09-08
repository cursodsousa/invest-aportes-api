package io.github.dougllasfps.aportesapi.domain.usuarios;

import io.github.dougllasfps.aportesapi.application.exception.UnauthorizedException;
import io.github.dougllasfps.aportesapi.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    @Transactional
    public Usuario saveOrUpdate(Usuario usuario){
        encodePassword(usuario);
        return repository.save(usuario);
    }

    protected void encodePassword(Usuario usuario) {
        String senha = usuario.getSenha();
        String encodeSenha = encoder.encode(senha);
        usuario.setSenha(encodeSenha);
    }

    public Optional<Usuario> auth( String email, String senha ){
        Usuario userDetails = getByEmail(email);
        if(encoder.matches(senha, userDetails.getSenha())){
            return Optional.of(userDetails);
        }
        throw new UnauthorizedException("Senha inválida");
    }

    public Usuario getByEmail(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UnauthorizedException("Email não cadastrado na base de dados."));
    }
}
