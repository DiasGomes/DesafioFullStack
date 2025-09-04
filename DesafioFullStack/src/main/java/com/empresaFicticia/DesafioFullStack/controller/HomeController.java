package com.empresaFicticia.DesafioFullStack.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.empresaFicticia.DesafioFullStack.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.empresaFicticia.DesafioFullStack.entity.Empresa;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Value("${app.frontend-url}")
    private String frontendUrl;

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/search")
    @CrossOrigin(origins = "${app.frontend-url}")
    public List<Empresa> getAllEmpresas(
        @RequestParam(value="q", defaultValue = "") String query,
        @RequestParam(value="noc", defaultValue = "true") Boolean nameOrCnpj 
    ) {
        if(!nameOrCnpj){
            return empresaRepository.findByCnpjContaining(query);
        }
        return empresaRepository.findByNomeFantasiaContaining(query);
    }

}
