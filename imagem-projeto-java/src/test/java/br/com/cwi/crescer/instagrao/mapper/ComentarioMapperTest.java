package br.com.cwi.crescer.instagrao.mapper;

import br.com.cwi.crescer.instagrao.controller.request.ComentarioRequest;
import br.com.cwi.crescer.instagrao.controller.response.ComentarioResponse;
import br.com.cwi.crescer.instagrao.domain.Comentario;
import br.com.cwi.crescer.instagrao.factories.ComentarioFactory;
import br.com.cwi.crescer.instagrao.service.core.NowService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ComentarioMapperTest {

    @Mock
    private NowService nowService;

    @Test
    @DisplayName("Deve retornar o response completo")
    void deveRetornarResponseCompleto() {
        Comentario comentario = ComentarioFactory.get();
        comentario.setDataComentario(nowService.getDateTime());

        ComentarioResponse response = ComentarioMapper.toResponse(comentario);

        assertEquals(comentario.getId(), response.getId());
        assertEquals(comentario.getUsuario().getNomeCompleto(), response.getNomeUsuario());
        assertEquals(comentario.getTexto(), response.getTexto());
        assertEquals(comentario.getPost().getId(), response.getPostId());
        assertEquals(comentario.getDataComentario(), response.getDataComentario());
    }

    @Test
    @DisplayName("Deve retornar a entity completa")
    void deveRetornarEntityCompleta() {
        ComentarioRequest request = new ComentarioRequest();
        request.setTexto("Texto teste");

        Comentario entity = ComentarioMapper.toEntity(request);

        assertEquals(request.getTexto(), entity.getTexto());
    }
}
