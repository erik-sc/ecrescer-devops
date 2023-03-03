package br.com.cwi.crescer.instagrao.repository;

import br.com.cwi.crescer.instagrao.domain.PedidoAmizade;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoAmizadeRepository extends JpaRepository<PedidoAmizade, Long> {

    boolean existsByUsuarioOrigemAndUsuarioDestino(Usuario usuarioOrigem, Usuario usuarioDestino);
}
