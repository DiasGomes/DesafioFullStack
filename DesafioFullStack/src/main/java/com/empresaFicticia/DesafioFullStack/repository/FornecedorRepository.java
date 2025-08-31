package com.empresaFicticia.DesafioFullStack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empresaFicticia.DesafioFullStack.entity.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
