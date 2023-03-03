package br.com.cwi.crescer.instagrao.repository;

import br.com.cwi.crescer.instagrao.domain.Amizade;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AmizadeRepository extends JpaRepository<Amizade, Long> {

    @Query("SELECT a.usuarioDestino FROM Amizade a WHERE a.usuarioOrigem = :usuario AND UPPER(a.usuarioDestino.nomeCompleto) LIKE %:nome%")
    Page<Usuario> findAmigoByUsuario(@Param("usuario") Usuario usuario, @Param("nome") String nome, Pageable pageable);
}
