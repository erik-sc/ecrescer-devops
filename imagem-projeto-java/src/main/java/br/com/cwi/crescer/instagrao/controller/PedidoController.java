package br.com.cwi.crescer.instagrao.controller;

import br.com.cwi.crescer.instagrao.controller.request.EnviarPedidoRequest;
import br.com.cwi.crescer.instagrao.controller.response.PedidoResponse;
import br.com.cwi.crescer.instagrao.service.EnviarPedidoService;
import br.com.cwi.crescer.instagrao.service.ListarPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private ListarPedidoService listarPedidoService;

    @Autowired
    private EnviarPedidoService enviarPedidoService;

    @GetMapping
    public Page<PedidoResponse> listarPedidos(Pageable pageable) {
        return listarPedidoService.listar(pageable);
    }

    @PostMapping
    public PedidoResponse enviarPedido(@Valid @RequestBody EnviarPedidoRequest request) {
        return enviarPedidoService.enviar(request);
    }
}
