package br.com.cwi.crescer.instagrao.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioRequest {

    @NotBlank(message = "não deve estar vazio")
    private String texto;
}
