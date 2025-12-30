package com.yehudi.backend.controller;

import com.yehudi.backend.model.Receita;
import com.yehudi.backend.service.ReceitaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceitaController {

    private final ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @GetMapping("/receitas")
    public List<Receita> buscar(@RequestParam String nome) {
        return service.buscarReceitas(nome);
    }
}
