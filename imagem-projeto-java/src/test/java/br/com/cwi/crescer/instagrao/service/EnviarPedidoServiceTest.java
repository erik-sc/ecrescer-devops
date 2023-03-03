package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.request.EnviarPedidoRequest;
import br.com.cwi.crescer.instagrao.controller.response.PedidoResponse;
import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;
import br.com.cwi.crescer.instagrao.factories.UsuarioFactory;
import br.com.cwi.crescer.instagrao.repository.PedidoAmizadeRepository;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.service.BuscarUsuarioService;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.instagrao.service.core.NowService;
import br.com.cwi.crescer.instagrao.validator.EnviarPedidoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnviarPedidoServiceTest {

    @InjectMocks
    private EnviarPedidoService tested;

    @Mock
    private PedidoAmizadeRepository pedidoAmizadeRepository;

    @Mock
    private NowService nowService;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private BuscarUsuarioService buscarUsuarioService;

    @Mock
    private EnviarPedidoValidator validator;

    @Captor
    private ArgumentCaptor<PedidoAmizade> pedidoCaptor;

    @Test
    @DisplayName("Deve enviar pedido corretamente")
    void deveEnviarCorretamente() {
        Usuario usuarioOrigem = UsuarioFactory.get();
        Usuario usuarioDestino = UsuarioFactory.get();

        when(usuarioAutenticadoService.get()).thenReturn(usuarioOrigem);
        when(buscarUsuarioService.porId(usuarioDestino.getId())).thenReturn(usuarioDestino);
        when(nowService.getDate()).thenReturn(LocalDate.now());

        EnviarPedidoRequest request = new EnviarPedidoRequest();
        request.setUsuarioDestinoId(usuarioDestino.getId());
        PedidoResponse response = tested.enviar(request);

        verify(pedidoAmizadeRepository).save(pedidoCaptor.capture());
        PedidoAmizade pedido = pedidoCaptor.getValue();

        assertEquals(response.getIdPedido(), pedido.getId());
        assertEquals(usuarioDestino, pedido.getUsuarioDestino());
        assertEquals(usuarioOrigem, pedido.getUsuarioOrigem());
    }
}
