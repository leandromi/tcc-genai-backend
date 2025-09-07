package com.exemplo.cadastro.controller;

import com.exemplo.cadastro.model.CadastroClienteRequest;
import com.exemplo.cadastro.service.CadastroClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/local")
public class CadastroClienteController {

    private final CadastroClienteService service;

    public CadastroClienteController(CadastroClienteService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody CadastroClienteRequest request,
                            @RequestHeader("Authorization") String token) {
        return service.cadastrarCliente(request, token.replace("Bearer ", ""));
    }
}
