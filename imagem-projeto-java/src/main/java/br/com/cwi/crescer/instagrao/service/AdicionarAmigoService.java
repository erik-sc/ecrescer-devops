package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;
import br.com.cwi.crescer.instagrao.repository.PedidoAmizadeRepository;
import br.com.cwi.crescer.instagrao.security.controller.response.UsuarioResumidoResponse;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.mapper.UsuarioResumidoMapper;
import br.com.cwi.crescer.instagrao.security.repository.UsuarioRepository;
import br.com.cwi.crescer.instagrao.service.core.BuscarPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdicionarAmigoService {

    @Autowired
    private BuscarPedidoService buscarPedidoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoAmizadeRepository pedidoAmizadeRepository;

    @Transactional
    public UsuarioResumidoResponse adicionar(Long pedidoId) {
        PedidoAmizade pedido = buscarPedidoService.porId(pedidoId);
        Usuario usuarioAtual = pedido.getUsuarioOrigem();
        Usuario usuarioAdicionado = pedido.getUsuarioDestino();

        usuarioAtual.adicionarAmigo(usuarioAdicionado);

        usuarioRepository.save(usuarioAtual);
        pedidoAmizadeRepository.delete(pedido);

        return UsuarioResumidoMapper.toResponse(usuarioAdicionado);
    }
}
