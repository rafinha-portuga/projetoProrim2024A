package br.univille.projprorim2024a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projprorim2024a.entity.Empresa;


@Repository
public interface EmpresaRepository 
        extends JpaRepository<Empresa,Long>{
    
}
