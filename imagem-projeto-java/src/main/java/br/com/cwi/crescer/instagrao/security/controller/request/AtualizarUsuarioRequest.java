package br.com.cwi.crescer.instagrao.security.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarUsuarioRequest {

    private String nomeCompleto;

    private String apelido;

    private LocalDate dataNascimento;

    private String email;

    private String imagemPerfil;

}
