package br.com.cwi.crescer.instagrao.controller;

import br.com.cwi.crescer.instagrao.controller.request.ComentarioRequest;
import br.com.cwi.crescer.instagrao.controller.response.ComentarioResponse;
import br.com.cwi.crescer.instagrao.service.AtualizarComentarioService;
import br.com.cwi.crescer.instagrao.service.IncluirComentarioService;
import br.com.cwi.crescer.instagrao.service.ListarComentariosService;
import br.com.cwi.crescer.instagrao.service.RemoverComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private IncluirComentarioService incluirComentarioService;

    @Autowired
    private AtualizarComentarioService atualizarComentarioService;

    @Autowired
    private RemoverComentarioService removerComentarioService;

    @Autowired
    private ListarComentariosService listarComentariosService;

    @PostMapping("/{postId}")
    @ResponseStatus(CREATED)
    public void incluir(@PathVariable Long postId, @Valid @RequestBody ComentarioRequest request) {
        incluirComentarioService.incluir(postId, request);
    }

    @PutMapping("/{comentarioId}")
    @ResponseStatus(CREATED)
    public void atualizar(@PathVariable Long comentarioId,
                          @Valid @RequestBody ComentarioRequest request) {
        atualizarComentarioService.atualizar(comentarioId, request);
    }

    @GetMapping("/{postId}")
    public List<ComentarioResponse> listar(@PathVariable Long postId) {
        return listarComentariosService.listar(postId);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(NO_CONTENT)
    public void remover(@PathVariable Long postId) {
        removerComentarioService.remover(postId);
    }
}
