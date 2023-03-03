package br.com.cwi.crescer.instagrao.mapper;

import br.com.cwi.crescer.instagrao.controller.request.IncluirPostRequest;
import br.com.cwi.crescer.instagrao.domain.Post;

public class IncluirPostMapper {

    public static Post toEntity(IncluirPostRequest request) {
        Post post = new Post();

        post.setTexto(request.getTexto());
        post.setImagem(request.getImagem());
        post.setPublico(request.getPublico());

        return post;
    }
}
