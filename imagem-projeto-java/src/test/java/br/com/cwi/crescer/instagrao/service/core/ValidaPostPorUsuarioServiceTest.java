package br.com.cwi.crescer.instagrao.service.core;

import br.com.cwi.crescer.instagrao.factories.PostFactory;
import br.com.cwi.crescer.instagrao.factories.UsuarioFactory;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidaPostPorUsuarioServiceTest {

    @InjectMocks
    private ValidaPostPorUsuarioService tested;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Test
    @DisplayName("Deve retornar erro quando post não for do usuario")
    void deveRetornarErro() {
        Usuario usuario = UsuarioFactory.get();

        when(usuarioAutenticadoService.get()).thenReturn(usuario);

        Long postId = PostFactory.get().getId();

        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () -> tested
                        .validar(postId));

        assertEquals("Só podem ser alterados posts do usuário logado", exception.getReason());
    }

}
