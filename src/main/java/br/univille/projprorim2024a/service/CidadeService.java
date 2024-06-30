package br.univille.projprorim2024a.service;

import java.util.List;

import br.univille.projprorim2024a.entity.Cidade;

public interface CidadeService {
    List<Cidade> getAll();
    void save(Cidade cidade);
    Cidade getById(long id);
    Cidade delete(long id);
}
