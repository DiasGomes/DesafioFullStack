package com.empresaFicticia.DesafioFullStack.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.HashSet;
import jakarta.persistence.*;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 14, nullable = false, unique = true)
    private String cpfCnpj;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String cep;
    @Column
    private String rg;
    @Column
    private LocalDate dataNascimento;
    @ManyToMany(mappedBy = "fornecedores")
    @JsonIgnore
    private Set<Empresa> empresas = new HashSet<>();

    public Fornecedor() {}

    public Fornecedor(Long id, String cpfCnpj, String nome, String email, String cep, String rg, LocalDate dataNascimento) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {return id;}
    public String getCpfCnpj() {return cpfCnpj;}
    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getCEP() {return cep;}
    public String getRg() {return rg;}
    public LocalDate getDataNascimento() {return dataNascimento;}
    public Set<Empresa> getEmpresas() {return empresas;}

    public void setId(Long id) {this.id = id;}
    public void setCpfCnpj(String cpfCnpj) {this.cpfCnpj = cpfCnpj;}
    public void setNome(String nome) {this.nome = nome;}
    public void setEmail(String email){this.email = email;}
    public void setCEP(String cep) {this.cep = cep;}
    public void setRg(String rg) {this.rg = rg;}
    public void setDataNascimento(LocalDate dataNascimento) {this.dataNascimento = dataNascimento;}
    public void setEmpresas(Set<Empresa> empresas) {this.empresas = empresas;}

}