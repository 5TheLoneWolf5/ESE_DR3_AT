package com.exemplo.fornecedorservice.config;

import com.exemplo.fornecedorservice.model.Fornecedor;
import com.exemplo.fornecedorservice.repository.FornecedorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Popula o banco H2 em memoria com clientes de teste assim que a aplicacao sobe.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final FornecedorRepository fornecedorRepository;

    public DataInitializer(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public void run(String... args) {
        fornecedorRepository.save(new Fornecedor("Ana Souza", "425923042432"));
        fornecedorRepository.save(new Fornecedor("Bruno Lima", "355523"));
        fornecedorRepository.save(new Fornecedor("Carla Mendes", "08236493"));
        fornecedorRepository.save(new Fornecedor("Diego Rocha", "957382044"));
        fornecedorRepository.save(new Fornecedor("Elisa Prado", "30692865"));
    }
}
