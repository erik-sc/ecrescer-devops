package br.com.cwi.crescer.instagrao.service.core;

import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class BuscarPostService {

    @Autowired
    PostRepository postRepository;

    public Post porId(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, "Post não encontrado"));
    }
}
