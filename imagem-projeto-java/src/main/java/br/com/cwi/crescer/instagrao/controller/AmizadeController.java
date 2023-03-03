package br.com.cwi.crescer.instagrao.controller;

import br.com.cwi.crescer.instagrao.security.controller.response.UsuarioResumidoResponse;
import br.com.cwi.crescer.instagrao.service.AdicionarAmigoService;
import br.com.cwi.crescer.instagrao.service.ListarAmigosService;
import br.com.cwi.crescer.instagrao.service.RemoverAmigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/amizades")
public class AmizadeController {

    @Autowired
    private AdicionarAmigoService adicionarAmigoService;

    @Autowired
    private ListarAmigosService listarAmigosService;


    @Autowired
    private RemoverAmigoService removerAmigoService;

    @PostMapping("{pedidoId}")
    public UsuarioResumidoResponse adicionarAmigo(@PathVariable Long pedidoId) {
        return adicionarAmigoService.adicionar(pedidoId);
    }

    @GetMapping
    public Page<UsuarioResumidoResponse> listarAmigos(String filtro, Pageable pageable) {
        return listarAmigosService.listar(filtro, pageable);
    }

    @DeleteMapping("{amigoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAmigo(@PathVariable Long amigoId) {
        removerAmigoService.remover(amigoId);
    }
}
