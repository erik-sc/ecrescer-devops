package br.com.cwi.crescer.instagrao.controller.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EnviarPedidoRequest {

    @NotNull
    private Long usuarioDestinoId;

}
