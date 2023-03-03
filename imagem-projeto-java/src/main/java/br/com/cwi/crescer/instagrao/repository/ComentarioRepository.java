package br.com.cwi.crescer.instagrao.repository;


import br.com.cwi.crescer.instagrao.domain.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
