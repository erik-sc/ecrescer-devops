package br.com.cwi.crescer.instagrao.security.mapper;

import br.com.cwi.crescer.instagrao.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.instagrao.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario usuario = new Usuario();

        usuario.setNomeCompleto(request.getNomeCompleto());
        usuario.setApelido(request.getApelido());
        usuario.setEmail(request.getEmail());
        usuario.setDataNascimento(request.getDataNascimento());
        usuario.setImagemPerfil(request.getImagemPerfil());

        return usuario;
    }

    public static UsuarioResponse toResponse(Usuario entity) {
        return UsuarioResponse.builder()
                .id(entity.getId())
                .nomeCompleto(entity.getNomeCompleto())
                .email(entity.getEmail())
                .build();
    }
}
