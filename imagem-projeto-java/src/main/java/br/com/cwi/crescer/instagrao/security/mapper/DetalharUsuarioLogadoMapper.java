package br.com.cwi.crescer.instagrao.security.mapper;

import br.com.cwi.crescer.instagrao.security.controller.response.DetalharUsuarioLogadoResponse;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;

public class DetalharUsuarioLogadoMapper {

    public static DetalharUsuarioLogadoResponse toResponse(Usuario usuario) {
        return DetalharUsuarioLogadoResponse.builder()
                .id(usuario.getId())
                .nomeCompleto(usuario.getNomeCompleto())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .dataNascimento(usuario.getDataNascimento())
                .imagemPerfil(usuario.getImagemPerfil())
                .build();
    }
}
