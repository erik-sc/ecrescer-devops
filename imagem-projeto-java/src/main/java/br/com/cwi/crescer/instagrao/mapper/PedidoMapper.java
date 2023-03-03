package br.com.cwi.crescer.instagrao.mapper;

import br.com.cwi.crescer.instagrao.controller.response.PedidoResponse;
import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;

public class PedidoMapper {

    public static PedidoResponse toResponse(PedidoAmizade pedido) {
        return PedidoResponse.builder()
                .idPedido(pedido.getId())
                .nomeUsuarioOrigem(pedido.getUsuarioOrigem().getNomeCompleto())
                .nomeUsuarioDestino(pedido.getUsuarioDestino().getNomeCompleto())
                .dataPedido(pedido.getDataPedido())
                .build();
    }
}
