package br.com.cwi.crescer.instagrao.service.core;

import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ValidaPostPorUsuarioService {
    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public void validar(Long postId) {
        Usuario usuario = usuarioAutenticadoService.get();

        if (usuario.getPosts().stream().noneMatch(post -> postId.equals(post.getId()))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só podem ser alterados posts do usuário logado");
        }
    }
}
