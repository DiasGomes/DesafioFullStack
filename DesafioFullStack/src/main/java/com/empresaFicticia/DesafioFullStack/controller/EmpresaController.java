package com.empresaFicticia.DesafioFullStack.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.empresaFicticia.DesafioFullStack.entity.Empresa;
import com.empresaFicticia.DesafioFullStack.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "http://localhost:5173")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping
    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    @PostMapping
    public Empresa createFornecedor(@RequestBody Empresa body) {
        return empresaRepository.save(body);
    }

}
