package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;
import br.com.cwi.crescer.instagrao.factories.PedidoFactory;
import br.com.cwi.crescer.instagrao.repository.PedidoAmizadeRepository;
import br.com.cwi.crescer.instagrao.security.controller.response.UsuarioResumidoResponse;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.repository.UsuarioRepository;
import br.com.cwi.crescer.instagrao.service.core.BuscarPedidoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdicionarAmigoServiceTest {

    @InjectMocks
    private AdicionarAmigoService tested;

    @Mock
    private BuscarPedidoService buscarPedidoService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PedidoAmizadeRepository pedidoAmizadeRepository;

    @Captor
    private ArgumentCaptor<Usuario> usuarioCaptor;
    @Test
    @DisplayName("Deve adicionar amigo corretamente")
    void deveAdicionarCorretamente() {
        PedidoAmizade pedido = PedidoFactory.get();
        when(buscarPedidoService.porId(pedido.getId()))
                .thenReturn(pedido);

        UsuarioResumidoResponse response = tested.adicionar(pedido.getId());

        verify(usuarioRepository).save(usuarioCaptor.capture());
        verify(pedidoAmizadeRepository).delete(pedido);

        Usuario usuario = usuarioCaptor.getValue();
        assertEquals(pedido.getUsuarioDestino().getId(), response.getId());
        assertEquals(usuario.getAmigos().get(0), pedido.getUsuarioDestino());
    }
}
