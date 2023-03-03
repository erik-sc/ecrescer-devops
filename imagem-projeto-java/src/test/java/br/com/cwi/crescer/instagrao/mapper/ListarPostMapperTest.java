package br.com.cwi.crescer.instagrao.mapper;

import br.com.cwi.crescer.instagrao.controller.response.PostResponse;
import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.factories.PostFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ListarPostMapperTest {

    @Test
    @DisplayName("Deve retornar o response completo")
    void deveRetornarResponse() {
        Post post = PostFactory.get();
        post.setDataPostagem(LocalDateTime.now());

        PostResponse response = ListarPostMapper.toResponse(post);

        assertEquals(post.getId(), response.getId());
        assertEquals(post.getUsuario().getNomeCompleto(), response.getNomeUsuario());
        assertEquals(post.getTexto(), response.getTexto());
        assertEquals(post.getImagem(), response.getImagemUrl());
        assertEquals(post.getComentarios().size(), response.getQuantComentarios());
        assertEquals(post.getCurtidas().size(), response.getQuantCurtidas());
        assertEquals(post.getDataPostagem(), response.getDataPostagem());
    }
}