package com.empresaFicticia.DesafioFullStack.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.empresaFicticia.DesafioFullStack.entity.Empresa;
import com.empresaFicticia.DesafioFullStack.repository.EmpresaRepository;
import com.empresaFicticia.DesafioFullStack.entity.Fornecedor;
import com.empresaFicticia.DesafioFullStack.repository.FornecedorRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Value("${app.frontend-url}")
    private String frontendUrl;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    // Pega informações da propria empresa e seus fornecedores
    @CrossOrigin(origins = "${app.frontend-url}")
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable Long id) {
        return empresaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // pesquisa fornecedores
    @GetMapping("/search")
    @CrossOrigin(origins = "${app.frontend-url}")
    public List<Fornecedor> getFornecedor(
        @RequestParam(value="q", defaultValue = "") String query,
        @RequestParam(value="noc", defaultValue = "true") Boolean nameOrCnpj 
    ) {
        if(!nameOrCnpj){
            return fornecedorRepository.findByCpfCnpjContaining(query);
        }
        return fornecedorRepository.findByNomeContaining(query);
    }

    // cria um fornecedor e vincula a empresa da pagina
    @CrossOrigin(
        origins = "${app.frontend-url}", allowedHeaders = "*", 
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
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

    @CrossOrigin(
        origins = "${app.frontend-url}", allowedHeaders = "*", 
        methods = {RequestMethod.POST, RequestMethod.OPTIONS})
    @PostMapping("/{id}/fornecedores/{fornecedorId}")
    public ResponseEntity<?> vincularFornecedor(
            @PathVariable Long id, 
            @PathVariable Long fornecedorId) {

        Optional<Empresa> empresaOpt = empresaRepository.findById(id);
        Optional<Fornecedor> fornecedorOpt = fornecedorRepository.findById(fornecedorId);

        if (empresaOpt.isPresent() && fornecedorOpt.isPresent()) {
            Empresa empresa = empresaOpt.get();
            Fornecedor fornecedor = fornecedorOpt.get();

            empresa.getFornecedores().add(fornecedor);
            empresaRepository.save(empresa);

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
