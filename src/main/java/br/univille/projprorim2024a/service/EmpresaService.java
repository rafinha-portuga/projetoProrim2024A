package br.univille.projprorim2024a.service;

import java.util.List;
import br.univille.projprorim2024a.entity.Empresa;

public interface EmpresaService {
    void save(Empresa usuario);
    Empresa getById(long id);
    List<Empresa> getAll();
    Empresa delete(long id);
}
