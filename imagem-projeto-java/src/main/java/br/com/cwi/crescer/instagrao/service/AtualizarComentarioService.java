package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.controller.request.ComentarioRequest;
import br.com.cwi.crescer.instagrao.domain.Comentario;
import br.com.cwi.crescer.instagrao.repository.ComentarioRepository;
import br.com.cwi.crescer.instagrao.service.core.BuscarComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarComentarioService {

    @Autowired
    private BuscarComentarioService buscarComentarioService;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public void atualizar(Long comentarioId, ComentarioRequest request) {
        Comentario comentario = buscarComentarioService.porId(comentarioId);

        comentario.setTexto(request.getTexto());

        comentarioRepository.save(comentario);
    }
}
