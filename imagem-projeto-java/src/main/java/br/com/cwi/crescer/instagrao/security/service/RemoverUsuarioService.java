package br.com.cwi.crescer.instagrao.security.service;

import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoverUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void remover() {
        Usuario usuario = usuarioAutenticadoService.get();

        usuario.setAtivo(false);
        usuario.setNomeCompleto(usuario.getId().toString());
        usuario.setApelido(null);
        usuario.setEmail("removido");

        usuarioRepository.save(usuario);
    }
}
