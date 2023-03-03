package br.com.cwi.crescer.instagrao.factories;

import br.com.cwi.crescer.instagrao.domain.Curtida;
import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;

public class CurtidaFactory {

    public static Curtida get(Usuario usuario, Post post) {
        Curtida curtida = new Curtida();
        curtida.setId(SimpleFactory.getRandomLong());
        curtida.setPost(post);
        curtida.setUsuario(usuario);
        return curtida;
    }
}
