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
public class PostResponse {

    private Long id;

    private Long idUsuario;

    private String nomeUsuario;

    private String texto;

    private String imagemUrl;

    private LocalDateTime dataPostagem;

    private Integer quantCurtidas;

    private Integer quantComentarios;
}
