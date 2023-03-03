package br.com.cwi.crescer.instagrao.service.core;

import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.factories.CurtidaFactory;
import br.com.cwi.crescer.instagrao.factories.PostFactory;
import br.com.cwi.crescer.instagrao.factories.UsuarioFactory;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ValidaCurtidaUnicaServiceTest {

    @InjectMocks
    private ValidaCurtidaUnicaService tested;

    @Test
    @DisplayName("Deve retornar erro quando já estiver curtido")
    void deveRetornarErro() {
        Usuario usuario = UsuarioFactory.get();
        Post post = PostFactory.get();

        usuario.getCurtidas().add(CurtidaFactory.get(usuario, post));
        ResponseStatusException exception =
                assertThrows(ResponseStatusException.class, () -> tested
                        .validar(usuario, post.getId()));

        assertEquals("Post não pode ser curtido duas vezes pelo mesmo usuário", exception.getReason());
    }

}
