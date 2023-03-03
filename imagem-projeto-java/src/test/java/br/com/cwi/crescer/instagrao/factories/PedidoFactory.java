package br.com.cwi.crescer.instagrao.factories;


import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;

public class PedidoFactory {

    public static PedidoAmizade getSemUsuarios() {
        PedidoAmizade pedidoAmizade = new PedidoAmizade();

        pedidoAmizade.setId(SimpleFactory.getRandomLong());
        return pedidoAmizade;
    }
    public static PedidoAmizade get() {
        PedidoAmizade pedidoAmizade = new PedidoAmizade();

        pedidoAmizade.setId(SimpleFactory.getRandomLong());
        pedidoAmizade.setUsuarioOrigem(UsuarioFactory.get());
        pedidoAmizade.setUsuarioDestino(UsuarioFactory.get());
        return pedidoAmizade;
    }

    public static PedidoAmizade get(Usuario usuarioOrigem) {
        PedidoAmizade pedidoAmizade = new PedidoAmizade();

        pedidoAmizade.setId(SimpleFactory.getRandomLong());
        pedidoAmizade.setUsuarioOrigem(usuarioOrigem);
        pedidoAmizade.setUsuarioDestino(UsuarioFactory.get());
        return pedidoAmizade;
    }
}
