package br.com.cwi.crescer.instagrao.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncluirPostRequest {

    @NotBlank
    private String texto;

    @URL(message = "Url precisa ser válida")
    private String imagem;

    @NotNull
    private Boolean publico;
}
