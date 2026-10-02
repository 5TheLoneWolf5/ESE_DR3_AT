package com.exemplo.fornecedorservice.controller;

import com.exemplo.fornecedorservice.dto.FornecedorDTO;
import com.exemplo.fornecedorservice.model.Fornecedor;
import com.exemplo.fornecedorservice.service.FornecedorService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fornecedor> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Fornecedor> adicionarFornecedor(@RequestBody FornecedorDTO fornecedor) {

        Fornecedor fornecedorAdicionado = new Fornecedor(
                fornecedor.nome(),
                fornecedor.cnpj()
        );

        service.adicionar(fornecedorAdicionado);

        return new ResponseEntity<>(fornecedorAdicionado, HttpStatusCode.valueOf(201));
    }
}