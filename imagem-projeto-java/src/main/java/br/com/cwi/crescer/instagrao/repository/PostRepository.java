package br.com.cwi.crescer.instagrao.repository;


import br.com.cwi.crescer.instagrao.domain.Post;
import br.com.cwi.crescer.instagrao.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByUsuario(Usuario usuario, Pageable pageable);

    Page<Post> findByPublicoAndUsuario(Boolean publico, Usuario usuario, Pageable pageable);
}
