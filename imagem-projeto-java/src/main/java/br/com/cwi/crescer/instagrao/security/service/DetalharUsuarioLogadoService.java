package br.com.cwi.crescer.instagrao.security.service;

import br.com.cwi.crescer.instagrao.security.controller.response.DetalharUsuarioLogadoResponse;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.crescer.instagrao.security.mapper.DetalharUsuarioLogadoMapper.toResponse;

@Service
public class DetalharUsuarioLogadoService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;


    public DetalharUsuarioLogadoResponse detalhar() {
        Usuario usuario = usuarioAutenticadoService.get();

        return toResponse(usuario);
    }
}
