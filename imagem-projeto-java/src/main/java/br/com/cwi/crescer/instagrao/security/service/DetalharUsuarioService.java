package br.com.cwi.crescer.instagrao.security.service;

import br.com.cwi.crescer.instagrao.security.controller.response.UsuarioResumidoResponse;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.mapper.UsuarioResumidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalharUsuarioService {

    @Autowired
    BuscarUsuarioService buscarUsuarioService;
    public UsuarioResumidoResponse detalhar(Long id) {
        Usuario usuario = buscarUsuarioService.porId(id);

        return UsuarioResumidoMapper.toResponse(usuario);
    }
}
