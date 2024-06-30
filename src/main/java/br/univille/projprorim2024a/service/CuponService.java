package br.univille.projprorim2024a.service;

import java.util.List;
import br.univille.projprorim2024a.entity.Cupon;
import br.univille.projprorim2024a.entity.Empresa;

public interface CuponService {
    void save(Cupon usuario);
    Cupon getById(long id);
    List<Cupon> getCuponByEmpresa(Empresa empresa);
    List<Cupon> getAll();
    Cupon delete(long id);
}
