package com.empresaFicticia.DesafioFullStack.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.empresaFicticia.DesafioFullStack.entity.Fornecedor;
import com.empresaFicticia.DesafioFullStack.repository.FornecedorRepository;

@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "http://localhost:5173")
public class EmpresaController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping("/{id}")
    public List<Fornecedor> getAllFornecedor() {
        return fornecedorRepository.findAll();
    }

    @PostMapping
    public Fornecedor createFornecedor(@RequestBody Fornecedor body) {
        return fornecedorRepository.save(body);
    }

}
