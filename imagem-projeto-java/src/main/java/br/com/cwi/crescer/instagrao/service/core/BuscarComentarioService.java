package br.com.cwi.crescer.instagrao.service.core;

import br.com.cwi.crescer.instagrao.domain.Comentario;
import br.com.cwi.crescer.instagrao.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BuscarComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public Comentario porId(Long id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comentário não encontrado"));
    }
}
