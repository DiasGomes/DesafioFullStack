package com.empresaFicticia.DesafioFullStack.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 14, nullable = false, unique = true)
    private String cnpj;
    @Column(nullable = false)
    private String nomeFantasia;
    @Column(nullable = false)
    private String cep;

    public Empresa() {}

    public Empresa(Long id, String cnpj, String nomeFantasia, String cep) {
        this.id = id;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.cep = cep;
    }

    public Long getId() {return id;}
    public String getCNPJ() {return cnpj;}
    public String getNomeFantasia() {return nomeFantasia;}
    public String getCEP() {return cep;}

    public void setId(Long id) {this.id = id;}
    public void setCNPJ(String cnpj) {this.cnpj = cnpj;}
    public void setNomeFantasia(String nomeFantasia) {this.nomeFantasia = nomeFantasia;}
    public void setCEP(String cep) {this.cep = cep;}

}
