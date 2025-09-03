package com.empresaFicticia.DesafioFullStack.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.empresaFicticia.DesafioFullStack.entity.Empresa;
import com.empresaFicticia.DesafioFullStack.repository.EmpresaRepository;
import com.empresaFicticia.DesafioFullStack.entity.Fornecedor;
import com.empresaFicticia.DesafioFullStack.repository.FornecedorRepository;

@RestController
@RequestMapping("/empresa")
@CrossOrigin(
    origins = "http://localhost:5173", 
    allowedHeaders = "*", 
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS}
    )
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable Long id) {
        return empresaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<Fornecedor> createFornecedor(
            @PathVariable Long id, @RequestBody Fornecedor body) {

        return empresaRepository.findById(id).map(empresa -> {
            // adiciona fornecedor
            empresa.getFornecedores().add(body);

            // salva fornecedor e empresa (dependendo do cascade)
            Fornecedor saved = fornecedorRepository.save(body);
            empresaRepository.save(empresa);

            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
}


}
