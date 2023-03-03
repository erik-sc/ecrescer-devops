package br.com.cwi.crescer.instagrao.factories;

import br.com.cwi.crescer.instagrao.domain.Comentario;

import java.time.LocalDateTime;

public class ComentarioFactory {

    public static Comentario get() {
        Comentario comentario = new Comentario();

        comentario.setId(SimpleFactory.getRandomLong());
        comentario.setTexto("Isso é um comentário teste");
        comentario.setUsuario(UsuarioFactory.get());
        comentario.setPost(PostFactory.get());

        return comentario;
    }

    public static Comentario getComData() {
        Comentario comentario = get();

        comentario.setDataComentario(LocalDateTime.now());
        return comentario;
    }
}
