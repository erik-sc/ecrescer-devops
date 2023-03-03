package br.com.cwi.crescer.instagrao.security.mapper;

import br.com.cwi.crescer.instagrao.security.controller.response.UsuarioResumidoResponse;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;

public class UsuarioResumidoMapper {
    public static UsuarioResumidoResponse toResponse(Usuario usuario) {
        return UsuarioResumidoResponse.builder()
                .id(usuario.getId())
                .nomeCompleto(usuario.getNomeCompleto())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .imagemPerfil(usuario.getImagemPerfil())
                .build();
    }
}
