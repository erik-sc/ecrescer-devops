package br.com.cwi.crescer.instagrao.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarPostRequest {

    private String texto;

    @URL(message = "Url precisa ser válida")
    private String imagem;

    private Boolean publico;
}
