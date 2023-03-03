package br.com.cwi.crescer.instagrao.service.core;

import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;
import br.com.cwi.crescer.instagrao.repository.PedidoAmizadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarPedidoService {
    @Autowired
    private PedidoAmizadeRepository pedidoAmizadeRepository;

    public PedidoAmizade porId(Long id) {
        return pedidoAmizadeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pedido não encontrado"));
    }
}
