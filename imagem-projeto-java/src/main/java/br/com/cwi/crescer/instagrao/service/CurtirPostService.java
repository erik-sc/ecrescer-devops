package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.domain.Curtida;
import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.repository.CurtidaRepository;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.instagrao.service.core.BuscarPostService;
import br.com.cwi.crescer.instagrao.service.core.NowService;
import br.com.cwi.crescer.instagrao.service.core.ValidaCurtidaUnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurtirPostService {

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;
    @Autowired
    private NowService nowService;
    @Autowired
    private BuscarPostService buscarPostService;

    @Autowired
    private ValidaCurtidaUnicaService validaCurtidaUnicaService;

    public void curtir(Long postId) {

        Usuario usuario = usuarioAutenticadoService.get();

        validaCurtidaUnicaService.validar(usuario, postId);

        Post post = buscarPostService.porId(postId);
        Curtida curtida = new Curtida();

        curtida.setDataCurtida(nowService.getDateTime());
        curtida.setPost(post);
        curtida.setUsuario(usuario);

        curtidaRepository.save(curtida);
    }
}
