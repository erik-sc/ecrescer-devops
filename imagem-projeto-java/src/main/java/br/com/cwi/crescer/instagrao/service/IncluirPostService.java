package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.request.IncluirPostRequest;
import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.mapper.IncluirPostMapper;
import br.com.cwi.crescer.instagrao.repository.PostRepository;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.instagrao.service.core.NowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncluirPostService {

    @Autowired
    private NowService nowService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public void incluir(IncluirPostRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        Post post = IncluirPostMapper.toEntity(request);

        post.setDataPostagem(nowService.getDateTime());
        post.setUsuario(usuario);

        postRepository.save(post);
    }
}
