package br.com.cwi.crescer.instagrao.mapper;

import br.com.cwi.crescer.instagrao.controller.response.PedidoResponse;
import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;
import br.com.cwi.crescer.instagrao.factories.PedidoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PedidoMapperTest {

    @Test
    @DisplayName("Deve retornar o response completo")
    void deveRetornarResponse() {
        PedidoAmizade pedidoAmizade = PedidoFactory.get();
        pedidoAmizade.setDataPedido(LocalDate.now());

        PedidoResponse response = PedidoMapper.toResponse(pedidoAmizade);

        assertEquals(pedidoAmizade.getId(), response.getIdPedido());
        assertEquals(pedidoAmizade.getUsuarioOrigem().getNomeCompleto(), response.getNomeUsuarioOrigem());
        assertEquals(pedidoAmizade.getUsuarioDestino().getNomeCompleto(), response.getNomeUsuarioDestino());
        assertEquals(pedidoAmizade.getDataPedido(), response.getDataPedido());
    }
}
