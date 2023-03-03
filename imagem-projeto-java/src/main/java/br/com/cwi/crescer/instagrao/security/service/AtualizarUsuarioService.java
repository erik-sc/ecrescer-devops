package br.com.cwi.crescer.instagrao.security.service;

import br.com.cwi.crescer.instagrao.security.controller.request.AtualizarUsuarioRequest;
import br.com.cwi.crescer.instagrao.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import br.com.cwi.crescer.instagrao.security.mapper.UsuarioMapper;
import br.com.cwi.crescer.instagrao.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class AtualizarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponse atualizar(AtualizarUsuarioRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        usuario.setNomeCompleto(nonNull(request.getNomeCompleto()) ? request.getNomeCompleto() : usuario.getNomeCompleto());
        usuario.setEmail(nonNull(request.getEmail()) ? request.getEmail() : usuario.getEmail());
        usuario.setApelido(nonNull(request.getApelido()) ? request.getApelido() : usuario.getApelido());
        usuario.setDataNascimento(nonNull(request.getDataNascimento()) ? request.getDataNascimento() : usuario.getDataNascimento());
        usuario.setImagemPerfil(nonNull(request.getImagemPerfil()) ? request.getImagemPerfil() : usuario.getImagemPerfil());

        usuarioRepository.save(usuario);

        return UsuarioMapper.toResponse(usuario);
    }
}
