package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.factories.PostFactory;
import br.com.cwi.crescer.instagrao.repository.PostRepository;
import br.com.cwi.crescer.instagrao.service.core.ValidaPostPorUsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RemoverPostServiceTest {

    @InjectMocks
    private RemoverPostService tested;

    @Mock
    private PostRepository postRepository;

    @Mock
    private ValidaPostPorUsuarioService validaPostPorUsuarioService;

    @Test
    @DisplayName("Deve remover post corretamente")
    void deveListarProprio() {
        Post post = PostFactory.get();

        tested.remover(post.getId());

        verify(validaPostPorUsuarioService).validar(post.getId());
        verify(postRepository).deleteById(post.getId());
    }
}
