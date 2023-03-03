package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.response.PostResponse;
import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.factories.PostFactory;
import br.com.cwi.crescer.instagrao.factories.UsuarioFactory;
import br.com.cwi.crescer.instagrao.mapper.ListarPostMapper;
import br.com.cwi.crescer.instagrao.repository.PostRepository;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.service.BuscarUsuarioService;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListarPostServiceTest {

    @InjectMocks
    private ListarPostService tested;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private BuscarUsuarioService buscarUsuarioService;

    @Mock
    private PostRepository postRepository;

    @Test
    @DisplayName("Deve listar corretamente os proprios posts")
    void deveListarProprio() {
        Usuario usuario = UsuarioFactory.get();
        List<Post> posts = new ArrayList<>();
        posts.add(PostFactory.get(usuario));
        posts.add(PostFactory.get(usuario));
        posts.add(PostFactory.get(usuario));

        usuario.setPosts(posts);

        Pageable pageable = PageRequest.of(0,posts.size());

        Page<Post> page = new PageImpl<>(posts, pageable, posts.size());
        Page<PostResponse> pageEsperada = page.map(ListarPostMapper::toResponse);

        when(usuarioAutenticadoService.get()).thenReturn(usuario);
        when(buscarUsuarioService.porId(usuario.getId())).thenReturn(usuario);
        when(postRepository.findByUsuario(usuario, pageable)).thenReturn(page);

        Page<PostResponse> response = tested.listarPerfil(usuario.getId(), pageable);

        assertEquals(response, pageEsperada);
    }

    @Test
    @DisplayName("Deve listar corretamente posts de amigo")
    void deveListarAmigo() {
        Usuario usuarioLogado = UsuarioFactory.get();
        Usuario usuario = UsuarioFactory.get();

        List<Post> posts = new ArrayList<>();
        posts.add(PostFactory.get(usuario));
        posts.add(PostFactory.get(usuario));
        posts.add(PostFactory.get(usuario));

        usuario.setPosts(posts);
        usuarioLogado.getAmigos().add(usuario);

        Pageable pageable = PageRequest.of(0,posts.size());

        Page<Post> page = new PageImpl<>(posts, pageable, posts.size());
        Page<PostResponse> pageEsperada = page.map(ListarPostMapper::toResponse);

        when(usuarioAutenticadoService.get()).thenReturn(usuarioLogado);
        when(buscarUsuarioService.porId(usuario.getId())).thenReturn(usuario);
        when(postRepository.findByUsuario(usuario, pageable)).thenReturn(page);

        Page<PostResponse> response = tested.listarPerfil(usuario.getId(), pageable);

        assertEquals(response, pageEsperada);
    }

    @Test
    @DisplayName("Não deve listar posts privados de um desconhecido")
    void naoDeveListarPrivado() {
        Usuario usuarioLogado = UsuarioFactory.get();
        Usuario usuario = UsuarioFactory.get();

        List<Post> posts = new ArrayList<>();
        posts.add(PostFactory.get(usuario));
        posts.add(PostFactory.get(usuario));
        posts.add(PostFactory.get(usuario));
        usuario.setPosts(posts);

        List<Post> postsPublicos = posts.stream().filter(Post::getPublico).collect(Collectors.toList());

        Pageable pageable = PageRequest.of(0,5);

        Page<Post> page = new PageImpl<>(postsPublicos, pageable, postsPublicos.size());
        when(usuarioAutenticadoService.get()).thenReturn(usuarioLogado);
        when(buscarUsuarioService.porId(usuario.getId())).thenReturn(usuario);
        when(postRepository.findByPublicoAndUsuario(true, usuario, pageable))
                .thenReturn(page);
        Page<PostResponse> response = tested.listarPerfil(usuario.getId(), pageable);

        assertEquals(response.getTotalElements(), postsPublicos.size());
        assertTrue(response.isEmpty());
    }
}
