package br.com.cwi.crescer.instagrao.controller;

import br.com.cwi.crescer.instagrao.controller.response.ChecarCurtidaResponse;
import br.com.cwi.crescer.instagrao.service.CurtirPostService;
import br.com.cwi.crescer.instagrao.service.DescurtirPostService;
import br.com.cwi.crescer.instagrao.service.ChecarCurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {

    @Autowired
    private CurtirPostService curtirPostService;

    @Autowired
    private DescurtirPostService descurtirPostService;

    @Autowired
    private ChecarCurtidaService checarCurtidaService;

    @PostMapping("/{postId}")
    public void curtir(@PathVariable Long postId) {
        curtirPostService.curtir(postId);
    }

    @DeleteMapping("/{postId}")
    public void descurtir(@PathVariable Long postId) {
        descurtirPostService.descurtir(postId);
    }

    @GetMapping("/{postId}")
    public ChecarCurtidaResponse checarCurtida(@PathVariable Long postId) {
        return checarCurtidaService.checar(postId);
    }
}
