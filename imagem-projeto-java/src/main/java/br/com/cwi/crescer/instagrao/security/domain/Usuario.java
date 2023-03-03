package br.com.cwi.crescer.instagrao.security.domain;

import br.com.cwi.crescer.instagrao.domain.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nomeCompleto;

    private String apelido;

    private LocalDate dataNascimento;

    private String email;

    private String senha;

    private String imagemPerfil;

    private boolean ativo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Curtida> curtidas = new ArrayList<>();


    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name="amizade",
            joinColumns = @JoinColumn(name = "usuario_origem_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_destino_id")
    )
    private List<Usuario> amigos = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioDestino")
    private List<PedidoAmizade> pedidoAmizades = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }

    public void adicionarAmigo(Usuario amigo) {
        this.amigos.add(amigo);
        amigo.getAmigos().add(this);
    }

    public void removerAmigo(Usuario amigo) {
        this.amigos.remove(amigo);
        amigo.getAmigos().remove(this);
    }
}
