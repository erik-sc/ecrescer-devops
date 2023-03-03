package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.repository.UsuarioRepository;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RemoverAmigoService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void remover(Long amigoId) {
        Usuario usuario = usuarioAutenticadoService.get();

        Usuario amigo = usuario
                .getAmigos().stream()
                .filter(amigo1 -> amigo1.getId().equals(amigoId)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Amigo não encontrado"));

        usuario.removerAmigo(amigo);
        usuarioRepository.save(usuario);
    }
}
