package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.domain.Curtida;
import br.com.cwi.crescer.instagrao.repository.CurtidaRepository;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.instagrao.service.core.BuscarPostService;
import br.com.cwi.crescer.instagrao.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DescurtirPostService {

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private NowService nowService;

    @Autowired
    private BuscarPostService buscarPostService;

    public void descurtir(Long postId) {
        Curtida curtida = usuarioAutenticadoService.get()
                .getCurtidas()
                .stream()
                .filter(curtidaItem -> curtidaItem.getPost().getId().equals(postId)).findFirst()
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Post não estava curtido"));

        curtidaRepository.delete(curtida);
    }
}
