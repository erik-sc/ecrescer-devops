package br.com.cwi.crescer.instagrao.service.core;

import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaCurtidaUnicaService {

    public void validar(Usuario usuario, Long postId) {
         if (usuario
                 .getCurtidas().stream()
                 .anyMatch(curtida -> curtida.getPost().getId().equals(postId))) {
            throw new ResponseStatusException(BAD_REQUEST, "Post não pode ser curtido duas vezes pelo mesmo usuário");
        }
    }
}
