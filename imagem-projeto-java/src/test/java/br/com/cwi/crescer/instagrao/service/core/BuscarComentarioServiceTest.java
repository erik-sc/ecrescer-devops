package br.com.cwi.crescer.instagrao.service.core;

import br.com.cwi.crescer.instagrao.domain.Comentario;
import br.com.cwi.crescer.instagrao.factories.ComentarioFactory;
import br.com.cwi.crescer.instagrao.repository.ComentarioRepository;
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
public class BuscarComentarioServiceTest {

    @InjectMocks
    private BuscarComentarioService tested;

    @Mock
    private ComentarioRepository repository;


    @Test
    @DisplayName("Deve retornar comentario quando existir")
    void deveRetornarComentario() {
        Comentario comentario = ComentarioFactory.get();
        when(repository.findById(comentario.getId()))
                .thenReturn(Optional.of(comentario));

        Comentario retorno = tested.porId(comentario.getId());

        verify(repository).findById(comentario.getId());
        assertEquals(comentario, retorno);
    }
    @Test
    @DisplayName("Deve retornar erro quando nao existir")
    void deveRetornarErro() {
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () -> tested.porId(1L));

        assertEquals("Comentário não encontrado", exception.getReason());
    }

}
