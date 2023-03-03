package br.com.cwi.crescer.instagrao.service;

import br.com.cwi.crescer.instagrao.repository.AmizadeRepository;
import br.com.cwi.crescer.instagrao.security.controller.response.UsuarioResumidoResponse;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.mapper.UsuarioResumidoMapper;
import br.com.cwi.crescer.instagrao.security.repository.UsuarioRepository;
import br.com.cwi.crescer.instagrao.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarAmigosService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<UsuarioResumidoResponse> listar(String filtro, Pageable pageable) {
        Usuario usuario = usuarioAutenticadoService.get();

        String filtroUpper = filtro.toUpperCase();


        return amizadeRepository
                .findAmigoByUsuario(usuario, filtroUpper, pageable)
                .map(UsuarioResumidoMapper::toResponse);
    }
}
