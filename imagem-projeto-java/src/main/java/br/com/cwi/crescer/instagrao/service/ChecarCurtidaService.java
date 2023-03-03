package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.response.ChecarCurtidaResponse;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChecarCurtidaService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public ChecarCurtidaResponse checar(Long postId) {
        Usuario usuario = usuarioAutenticadoService.get();
        boolean jaCurtiu = usuario.getCurtidas().stream().anyMatch(curtida -> curtida.getPost().getId().equals(postId));
        return ChecarCurtidaResponse.builder()
                .jaCurtiu(jaCurtiu)
                .build();
    }
}
