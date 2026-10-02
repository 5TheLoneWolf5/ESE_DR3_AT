package com.exemplo.fornecedorservice.service;

import com.exemplo.fornecedorservice.dto.FornecedorDTO;
import com.exemplo.fornecedorservice.model.Fornecedor;
import com.exemplo.fornecedorservice.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Regra de negocio de Cliente. O controller nao fala direto com o repository,
 * fala com este service.
 */
@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public void adicionar(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }
}
