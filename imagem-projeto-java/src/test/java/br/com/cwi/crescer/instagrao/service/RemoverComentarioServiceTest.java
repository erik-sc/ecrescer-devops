package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.domain.Comentario;
import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.factories.ComentarioFactory;
import br.com.cwi.crescer.instagrao.factories.PostFactory;
import br.com.cwi.crescer.instagrao.repository.ComentarioRepository;
import br.com.cwi.crescer.instagrao.service.core.BuscarComentarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RemoverComentarioServiceTest {

    @InjectMocks
    private RemoverComentarioService tested;

    @Mock
    private BuscarComentarioService buscarComentarioService;

    @Mock
    private ComentarioRepository comentarioRepository;

    @Test
    @DisplayName("Deve remover comentário corretamente")
    void deveRemoverComentario() {
        Post post = PostFactory.get();
        Comentario comentario = ComentarioFactory.get();
        comentario.setPost(post);
        post.getComentarios().add(comentario);

        when(buscarComentarioService.porId(comentario.getId()))
                .thenReturn(comentario);

        tested.remover(comentario.getId());

        assertTrue(post.getComentarios().isEmpty());
        verify(comentarioRepository).delete(comentario);
    }
}
