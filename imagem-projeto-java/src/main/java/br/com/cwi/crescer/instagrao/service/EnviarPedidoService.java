package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.request.EnviarPedidoRequest;
import br.com.cwi.crescer.instagrao.controller.response.PedidoResponse;
import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;
import br.com.cwi.crescer.instagrao.mapper.PedidoMapper;
import br.com.cwi.crescer.instagrao.repository.PedidoAmizadeRepository;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.service.BuscarUsuarioService;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import br.com.cwi.crescer.instagrao.service.core.NowService;
import br.com.cwi.crescer.instagrao.validator.EnviarPedidoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnviarPedidoService {

    @Autowired
    private PedidoAmizadeRepository pedidoAmizadeRepository;

    @Autowired
    private NowService nowService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private EnviarPedidoValidator validator;

    public PedidoResponse enviar(EnviarPedidoRequest request) {

        Usuario usuarioOrigem = usuarioAutenticadoService.get();
        Usuario usuarioDestino = buscarUsuarioService.porId(request.getUsuarioDestinoId());

        PedidoAmizade pedido = new PedidoAmizade();

        pedido.setDataPedido(nowService.getDate());
        pedido.setUsuarioOrigem(usuarioOrigem);
        pedido.setUsuarioDestino(usuarioDestino);

        validator.validar(pedido);

        pedidoAmizadeRepository.save(pedido);

        return PedidoMapper.toResponse(pedido);
    }
}
