package br.com.cwi.crescer.instagrao.domain;

import br.com.cwi.crescer.instagrao.security.domain.Usuario;

import javax.persistence.*;

@Entity
public class Amizade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_origem_id")
    private Usuario usuarioOrigem;

    @ManyToOne
    @JoinColumn(name = "usuario_destino_id")
    private Usuario usuarioDestino;

}
