package br.com.cwi.crescer.instagrao.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioResponse {

    private Long id;

    private Long postId;

    private String texto;

    private String nomeUsuario;

    private LocalDateTime dataComentario;

}
