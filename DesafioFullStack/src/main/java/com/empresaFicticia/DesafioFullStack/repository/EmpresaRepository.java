package com.empresaFicticia.DesafioFullStack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empresaFicticia.DesafioFullStack.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
