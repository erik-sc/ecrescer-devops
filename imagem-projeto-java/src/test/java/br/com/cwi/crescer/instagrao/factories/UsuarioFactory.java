package br.com.cwi.crescer.instagrao.factories;

import br.com.cwi.crescer.instagrao.security.domain.Usuario;

public class UsuarioFactory {

    public static Usuario get() {
        Usuario usuario = new Usuario();
        usuario.setId(SimpleFactory.getRandomLong());
        usuario.setNomeCompleto("Usuário de teste");
        usuario.setEmail("teste@cwi.com.br");
        return usuario;
    }
}
