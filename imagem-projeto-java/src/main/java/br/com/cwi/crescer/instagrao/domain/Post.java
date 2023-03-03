package br.com.cwi.crescer.instagrao.domain;

import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    private String texto;

    private String imagem;

    private LocalDateTime dataPostagem;

    private Boolean publico;

    @OneToMany(mappedBy = "post")
    private List<Curtida> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comentario> comentarios = new ArrayList<>();
}
