package br.com.cwi.crescer.instagrao.controller;

import br.com.cwi.crescer.instagrao.controller.request.AtualizarPostRequest;
import br.com.cwi.crescer.instagrao.controller.request.IncluirPostRequest;
import br.com.cwi.crescer.instagrao.controller.response.PostResponse;
import br.com.cwi.crescer.instagrao.service.AtualizarPostService;
import br.com.cwi.crescer.instagrao.service.IncluirPostService;
import br.com.cwi.crescer.instagrao.service.ListarPostService;
import br.com.cwi.crescer.instagrao.service.RemoverPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IncluirPostService incluirPostService;

    @Autowired
    private AtualizarPostService atualizarPostService;

    @Autowired
    private ListarPostService listarPostService;

    @Autowired
    private RemoverPostService removerPostService;


    @PostMapping
    @ResponseStatus(CREATED)
    public void incluir(@Valid @RequestBody IncluirPostRequest request) {
        incluirPostService.incluir(request);
    }

    @PutMapping("/{postId}")
    @ResponseStatus(NO_CONTENT)
    public void atualizar(@PathVariable Long postId, @Valid @RequestBody AtualizarPostRequest request) {
        atualizarPostService.atualizar(postId, request);
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(NO_CONTENT)
    public void remover(@PathVariable Long postId) {
        removerPostService.remover(postId);
    }

    @GetMapping("/{usuarioId}")
    public Page<PostResponse> listarPerfil(@PathVariable Long usuarioId, Pageable pageable) {
        return listarPostService.listarPerfil(usuarioId, pageable);
    }

    @GetMapping("/{usuarioId}/publico")
    public Page<PostResponse> listarPerfilPublico(@PathVariable Long usuarioId, Pageable pageable) {
        return listarPostService.listarPerfilPublico(usuarioId, pageable);
    }

    @GetMapping("/feed")
    public Page<PostResponse> listarFeed(Pageable pageable) {
        return listarPostService.listarFeed(pageable);
    }




}
