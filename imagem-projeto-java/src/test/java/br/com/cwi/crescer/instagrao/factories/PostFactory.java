package br.com.cwi.crescer.instagrao.factories;

import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;

public class PostFactory {

    public static Post get() {
        Post post = new Post();

        post.setId(SimpleFactory.getRandomLong());
        post.setTexto("Isso é um post teste");
        post.setUsuario(UsuarioFactory.get());
        post.setImagem("www.exemplo.com/imagem");
        post.setPublico(false);

        return post;
    }

    public static Post get(Usuario usuarioOrigem) {
        Post post = get();
        post.setUsuario(usuarioOrigem);
        return post;
    }
}
