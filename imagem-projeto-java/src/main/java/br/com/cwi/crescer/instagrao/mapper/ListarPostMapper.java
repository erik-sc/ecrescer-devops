package br.com.cwi.crescer.instagrao.mapper;

import br.com.cwi.crescer.instagrao.controller.response.PostResponse;
import br.com.cwi.crescer.instagrao.domain.Post;

public class ListarPostMapper {

    public static PostResponse toResponse(Post post) {

        return PostResponse.builder()
                .id(post.getId())
                .idUsuario(post.getUsuario().getId())
                .nomeUsuario(post.getUsuario().getNomeCompleto())
                .texto(post.getTexto())
                .imagemUrl(post.getImagem())
                .quantComentarios(post.getComentarios().size())
                .quantCurtidas(post.getCurtidas().size())
                .dataPostagem(post.getDataPostagem())
                .build();
    }
}
