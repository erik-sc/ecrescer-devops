package br.com.cwi.crescer.instagrao.service.core;

import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.factories.PostFactory;
import br.com.cwi.crescer.instagrao.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BuscarPostServiceTest {

    @InjectMocks
    private BuscarPostService tested;

    @Mock
    private PostRepository repository;


    @Test
    @DisplayName("Deve retornar post quando existir")
    void deveRetornarPost() {
        Post pedido = PostFactory.get();
        when(repository.findById(pedido.getId()))
                .thenReturn(Optional.of(pedido));

        Post retorno = tested.porId(pedido.getId());

        verify(repository).findById(pedido.getId());
        assertEquals(pedido, retorno);
    }
    @Test
    @DisplayName("Deve retornar erro quando nao existir")
    void deveRetornarErro() {
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () -> tested.porId(1L));

        assertEquals("Post não encontrado", exception.getReason());
    }

}
