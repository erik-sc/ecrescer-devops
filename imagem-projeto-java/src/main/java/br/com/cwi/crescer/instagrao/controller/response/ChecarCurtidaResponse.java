package br.com.cwi.crescer.instagrao.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChecarCurtidaResponse {

    private boolean jaCurtiu;
}
