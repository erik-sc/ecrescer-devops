package br.com.cwi.crescer.instagrao.mapper;

import br.com.cwi.crescer.instagrao.controller.request.IncluirPostRequest;
import br.com.cwi.crescer.instagrao.domain.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class IncluirPostMapperTest {

    @Test
    @DisplayName("Deve retornar entity completa")
    void deveRetornarEntity() {
        IncluirPostRequest request = new IncluirPostRequest();
        request.setTexto("Texto teste!");
        request.setImagem("exemplo.com");
        request.setPublico(true);

        Post post = IncluirPostMapper.toEntity(request);

        assertEquals(request.getTexto(), post.getTexto());
        assertEquals(request.getImagem(), post.getImagem());
        assertEquals(request.getPublico(), post.getPublico());
    }

}
