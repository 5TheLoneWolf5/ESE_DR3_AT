package com.exemplo.fornecedorservice.controller;

import com.exemplo.fornecedorservice.dto.FornecedorDTO;
import com.exemplo.fornecedorservice.dto.ProdutoDTO;
import com.exemplo.fornecedorservice.interfaces.ProdutoInterface;
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
    private final ProdutoInterface produtoInterface;

    public FornecedorController(FornecedorService service, ProdutoInterface produtoInterface) {
        this.service = service;
        this.produtoInterface = produtoInterface;
    }

    @GetMapping
    public List<Fornecedor> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/produtos")
    public List<ProdutoDTO> listarProdutos() {
        return produtoInterface.listarTodos();
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