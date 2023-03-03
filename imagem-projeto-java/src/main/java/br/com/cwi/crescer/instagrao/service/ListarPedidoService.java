package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.response.PedidoResponse;
import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;
import br.com.cwi.crescer.instagrao.mapper.PedidoMapper;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarPedidoService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;


    public Page<PedidoResponse> listar(Pageable pageable) {
        Usuario usuario = usuarioAutenticadoService.get();

        List<PedidoAmizade> pedidos = usuario.getPedidoAmizades();

        return new PageImpl<>(pedidos, pageable, pedidos.size()).map(PedidoMapper::toResponse);
    }
}
