package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.response.ComentarioResponse;
import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.mapper.ComentarioMapper;
import br.com.cwi.crescer.instagrao.service.core.BuscarPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarComentariosService {

    @Autowired
    private BuscarPostService buscarPostService;
    public List<ComentarioResponse> listar(Long postId) {
        Post post = buscarPostService.porId(postId);

        return post.getComentarios().stream()
                .map(ComentarioMapper::toResponse)
                .sorted(Comparator.comparing(ComentarioResponse::getDataComentario))
                .collect(Collectors.toList());
    }
}
