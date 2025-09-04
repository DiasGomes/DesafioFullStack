package com.empresaFicticia.DesafioFullStack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresaFicticia.DesafioFullStack.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    List<Fornecedor> findByNome(String nome);

    List<Fornecedor> findByCpfCnpj(String cnpj);

    List<Fornecedor> findByNomeContaining(String nome);

    List<Fornecedor> findByCpfCnpjContaining(String cnpj);

}
