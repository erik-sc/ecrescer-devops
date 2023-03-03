package br.com.cwi.crescer.instagrao.security.controller.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    @NotBlank
    private String nomeCompleto;

    private String apelido;

    @NotNull
    private LocalDate dataNascimento;

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String senha;

    private String imagemPerfil;
}
