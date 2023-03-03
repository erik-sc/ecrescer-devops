package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.request.AtualizarPostRequest;
import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.repository.PostRepository;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.instagrao.service.core.BuscarPostService;
import br.com.cwi.crescer.instagrao.service.core.ValidaPostPorUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class AtualizarPostService {

    @Autowired
    private BuscarPostService buscarPostService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ValidaPostPorUsuarioService validaPostPorUsuarioService;


    public void atualizar(Long postId, AtualizarPostRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        validaPostPorUsuarioService.validar(postId);

        Post post = buscarPostService.porId(postId);

        post.setTexto(isNull(request.getTexto()) ? post.getTexto() : request.getTexto());
        post.setImagem(isNull(request.getImagem()) ? post.getImagem() : request.getImagem());
        post.setPublico(isNull(request.getPublico()) ? post.getPublico() : request.getPublico());

        postRepository.save(post);
    }
}
