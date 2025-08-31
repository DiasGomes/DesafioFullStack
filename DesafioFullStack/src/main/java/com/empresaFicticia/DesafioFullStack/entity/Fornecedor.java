package com.empresaFicticia.DesafioFullStack.entity;

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

    public Fornecedor() {}

    public Fornecedor(Long id, String cpfCnpj, String nome, String email, String cep) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
    }

    public String getCpfCnpj() {return cpfCnpj;}
    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getCEP() {return cep;}

    public void setCpfCnpj(String cpfCnpj) {this.cpfCnpj = cpfCnpj;}
    public void setNome(String nome) {this.nome = nome;}
    public void setEmail(String email){this.email = email;}
    public void setCEP(String cep) {this.cep = cep;}

}