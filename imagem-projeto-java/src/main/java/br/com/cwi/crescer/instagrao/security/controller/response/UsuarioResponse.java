package br.com.cwi.crescer.instagrao.security.controller.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private Long id;
    private String nomeCompleto;
    private String email;
}
