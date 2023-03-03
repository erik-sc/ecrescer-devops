package br.com.cwi.crescer.instagrao.security.controller;

import br.com.cwi.crescer.instagrao.security.controller.request.AtualizarUsuarioRequest;
import br.com.cwi.crescer.instagrao.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.instagrao.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.instagrao.security.controller.response.UsuarioResumidoResponse;
import br.com.cwi.crescer.instagrao.security.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    @Autowired
    private AtualizarUsuarioService atualizarUsuarioService;

    @Autowired
    private RemoverUsuarioService removerUsuarioService;

    @Autowired
    private DetalharUsuarioLogadoService detalharUsuarioLogadoService;

    @Autowired
    private DetalharUsuarioService detalharUsuarioService;

    @Autowired
    private ListarUsuariosService listarUsuariosService;

    @PostMapping
    public UsuarioResponse incluir(@Valid @RequestBody UsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }

    @PutMapping
    public UsuarioResponse atualizar(@Valid @RequestBody AtualizarUsuarioRequest request) {
        return atualizarUsuarioService.atualizar(request);
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void remover() {
        removerUsuarioService.remover();
    }

    @GetMapping
    public Page<UsuarioResumidoResponse> listar(String filtro, Pageable pageable) {
        return listarUsuariosService.listar(filtro, pageable);
    }

    @GetMapping("/{id}")
    public UsuarioResumidoResponse detalharUsuario(@PathVariable Long id) {
        return detalharUsuarioService.detalhar(id);
    }
}
