package br.com.cwi.crescer.instagrao.service;


import br.com.cwi.crescer.instagrao.controller.response.PostResponse;
import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.mapper.ListarPostMapper;
import br.com.cwi.crescer.instagrao.repository.PostRepository;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.repository.UsuarioRepository;
import br.com.cwi.crescer.instagrao.security.service.BuscarUsuarioService;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarPostService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;
    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<PostResponse> listarPerfil(Long id, Pageable pageable) {
        Usuario usuario = buscarUsuarioService.porId(id);

        if (isAmigoOuRelacionado(usuario) ) {
            return listarPerfilPrivado(id, pageable);
        }
        return listarPerfilPublico(id, pageable);
    }

    private boolean isAmigoOuRelacionado(Usuario usuario) {
        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        return usuarioAutenticado.getAmigos().contains(usuario) || usuarioAutenticado.equals(usuario);
    }


    public Page<PostResponse> listarPerfilPrivado(Long id, Pageable pageable) {
        Usuario usuario = buscarUsuarioService.porId(id);

        List<Post> posts = usuario.getPosts();

        return postRepository.findByUsuario(usuario, pageable).map(ListarPostMapper::toResponse);
    }


    public Page<PostResponse> listarPerfilPublico(Long id, Pageable pageable) {
        Usuario usuario = buscarUsuarioService.porId(id);

        return postRepository.findByPublicoAndUsuario(true,usuario, pageable).map(ListarPostMapper::toResponse);
    }

    public Page<PostResponse> listarFeed(Pageable pageable) {

        List<PostResponse> posts = postRepository.findAll(pageable)
                .stream().filter(post -> post.getPublico() || isAmigoOuRelacionado(post.getUsuario()))
                .sorted(Comparator.comparing(Post::getDataPostagem).reversed())
                .map(ListarPostMapper::toResponse)
                .collect(Collectors.toList());

        return new PageImpl<>(posts);
    }
}
