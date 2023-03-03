package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.response.PedidoResponse;
import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;
import br.com.cwi.crescer.instagrao.factories.PedidoFactory;
import br.com.cwi.crescer.instagrao.factories.UsuarioFactory;
import br.com.cwi.crescer.instagrao.mapper.PedidoMapper;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListarPedidoServiceTest {

    @InjectMocks
    private ListarPedidoService tested;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Test
    @DisplayName("Deve listar corretamente")
    void deveEnviarCorretamente() {
        Usuario usuario = UsuarioFactory.get();
        List<PedidoAmizade> pedidos = new ArrayList<>();
        pedidos.add(PedidoFactory.get(usuario));
        pedidos.add(PedidoFactory.get(usuario));
        pedidos.add(PedidoFactory.get(usuario));
        usuario.setPedidoAmizades(pedidos);

        Pageable pageable = PageRequest.of(0,pedidos.size());

        Page<PedidoResponse> pageEsperada = new PageImpl<>(pedidos, pageable, pedidos.size())
                .map(PedidoMapper::toResponse);
        when(usuarioAutenticadoService.get()).thenReturn(usuario);

        Page<PedidoResponse> response = tested.listar(pageable);

        assertEquals(response, pageEsperada);
    }
}
