package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.domain.Comentario;
import br.com.cwi.crescer.instagrao.repository.ComentarioRepository;
import br.com.cwi.crescer.instagrao.service.core.BuscarComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoverComentarioService {

    @Autowired
    private BuscarComentarioService buscarComentarioService;

    @Autowired
    private ComentarioRepository comentarioRepository;


    public void remover(Long comentarioId) {
        Comentario comentario = buscarComentarioService.porId(comentarioId);

        comentario.getPost().getComentarios().remove(comentario);

        comentarioRepository.delete(comentario);
    }
}
