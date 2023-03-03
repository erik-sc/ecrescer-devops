package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.request.ComentarioRequest;
import br.com.cwi.crescer.instagrao.domain.Comentario;
import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.repository.ComentarioRepository;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.instagrao.service.core.BuscarPostService;
import br.com.cwi.crescer.instagrao.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.crescer.instagrao.mapper.ComentarioMapper.toEntity;

@Service
public class IncluirComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;
    @Autowired
    private BuscarPostService buscarPostService;

    @Autowired
    private NowService nowService;
    public void incluir(Long postId, ComentarioRequest request) {
        Post post = buscarPostService.porId(postId);
        Usuario usuario = usuarioAutenticadoService.get();
        Comentario comentario = toEntity(request);

        comentario.setPost(post);
        comentario.setUsuario(usuario);
        comentario.setDataComentario(nowService.getDateTime());

        comentarioRepository.save(comentario);
    }
}
