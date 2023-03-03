package br.com.cwi.crescer.instagrao.validator;

import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;
import br.com.cwi.crescer.instagrao.repository.PedidoAmizadeRepository;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Component
public class EnviarPedidoValidator {

    @Autowired
    private PedidoAmizadeRepository pedidoAmizadeRepository;

    public void validar(PedidoAmizade pedido) {
        Usuario usuarioOrigem = pedido.getUsuarioOrigem();
        Usuario usuarioDestino = pedido.getUsuarioDestino();

        if (pedidoAmizadeRepository.existsByUsuarioOrigemAndUsuarioDestino(usuarioOrigem, usuarioDestino)) {
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Um pedido já foi solicitado para este usuário");
        }
        if(pedidoAmizadeRepository.existsByUsuarioOrigemAndUsuarioDestino(usuarioDestino, usuarioOrigem)) {
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuário destinado tem solicitação enviada para usuário atual");
        }
        if (usuarioOrigem.equals(usuarioDestino)) {
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Usuário não pode enviar pedido a si mesmo");
        }
    }
}
