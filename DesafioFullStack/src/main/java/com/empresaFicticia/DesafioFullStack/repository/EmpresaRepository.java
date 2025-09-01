package com.empresaFicticia.DesafioFullStack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresaFicticia.DesafioFullStack.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    List<Empresa> findByNomeFantasia(String nome);

    List<Empresa> findByCnpj(String cnpj);

    List<Empresa> findByNomeFantasiaContaining(String nome);

    List<Empresa> findByCnpjContaining(String cnpj);
}
