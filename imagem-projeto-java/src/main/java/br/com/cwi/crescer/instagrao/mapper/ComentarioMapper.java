package br.com.cwi.crescer.instagrao.mapper;

import br.com.cwi.crescer.instagrao.controller.request.ComentarioRequest;
import br.com.cwi.crescer.instagrao.controller.response.ComentarioResponse;
import br.com.cwi.crescer.instagrao.domain.Comentario;

public class ComentarioMapper {
    public static Comentario toEntity(ComentarioRequest request) {
        return Comentario.builder()
                .texto(request.getTexto())
                .build();
    }

    public static ComentarioResponse toResponse(Comentario entity) {
        return ComentarioResponse.builder()
                .id(entity.getId())
                .nomeUsuario(entity.getUsuario().getNomeCompleto())
                .texto(entity.getTexto())
                .postId(entity.getPost().getId())
                .dataComentario(entity.getDataComentario())
                .build();
    }
}
