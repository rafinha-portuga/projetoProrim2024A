package br.univille.projprorim2024a.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projprorim2024a.entity.Cupon;
import br.univille.projprorim2024a.entity.Empresa;


@Repository
public interface CuponRepository 
        extends JpaRepository<Cupon,Long>{

        List<Cupon> getCuponByEmpresa(Empresa empresa);
}
