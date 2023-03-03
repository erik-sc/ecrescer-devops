package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.repository.PostRepository;
import br.com.cwi.crescer.instagrao.service.core.ValidaPostPorUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoverPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ValidaPostPorUsuarioService validaPostPorUsuarioService;

    public void remover(Long postId) {
        validaPostPorUsuarioService.validar(postId);
        postRepository.deleteById(postId);
    }
}
