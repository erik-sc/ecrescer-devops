package br.com.cwi.crescer.instagrao.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {

    private Long idPedido;

    private String nomeUsuarioOrigem;

    private String nomeUsuarioDestino;

    private LocalDate dataPedido;
}
