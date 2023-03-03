package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.factories.UsuarioFactory;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.repository.UsuarioRepository;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
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
public class RemoverAmigoServiceTest {

    @InjectMocks
    private RemoverAmigoService tested;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Deve remover amigo corretamente")
    void deveListarProprio() {
        Usuario usuario = UsuarioFactory.get();
        Usuario amigo = UsuarioFactory.get();
        usuario.getAmigos().add(amigo);

        when(usuarioAutenticadoService.get()).thenReturn(usuario);

        tested.remover(amigo.getId());

        verify(usuarioRepository).save(usuario);

        assertTrue(usuario.getAmigos().isEmpty());
    }
}
