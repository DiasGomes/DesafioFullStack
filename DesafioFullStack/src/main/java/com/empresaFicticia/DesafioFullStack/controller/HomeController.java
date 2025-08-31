package com.empresaFicticia.DesafioFullStack.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.empresaFicticia.DesafioFullStack.repository.FornecedorRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.empresaFicticia.DesafioFullStack.entity.Fornecedor;

@RestController
@RequestMapping("/fornecedor")
public class HomeController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping
    public List<Fornecedor> getAllFornecedores() {
        return fornecedorRepository.findAll();
    }

    @PostMapping
    public Fornecedor createFornecedor(@RequestBody Fornecedor body) {
        return fornecedorRepository.save(body);
    }

}
