package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.response.ComentarioResponse;
import br.com.cwi.crescer.instagrao.domain.Comentario;
import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.factories.ComentarioFactory;
import br.com.cwi.crescer.instagrao.factories.PostFactory;
import br.com.cwi.crescer.instagrao.mapper.ComentarioMapper;
import br.com.cwi.crescer.instagrao.service.core.BuscarPostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListarComentariosServiceTest {

    @InjectMocks
    private ListarComentariosService tested;

    @Mock
    private BuscarPostService buscarPostService;

    @Test
    @DisplayName("Deve listar corretamente")
    void deveEnviarCorretamente() {
        Post post = PostFactory.get();

        List<Comentario> comentarios = new ArrayList<>();
        comentarios.add(ComentarioFactory.getComData());
        comentarios.add(ComentarioFactory.getComData());
        comentarios.add(ComentarioFactory.getComData());
        post.setComentarios(comentarios);

        when(buscarPostService.porId(post.getId())).thenReturn(post);

        List<ComentarioResponse> lista = tested.listar(post.getId());

        List<ComentarioResponse> mapped = comentarios
                .stream().map(ComentarioMapper::toResponse)
                .sorted(Comparator.comparing(ComentarioResponse::getDataComentario))
                .collect(Collectors.toList());

        assertEquals(comentarios.size(), lista.size());
        assertEquals(mapped, lista);
    }
}
