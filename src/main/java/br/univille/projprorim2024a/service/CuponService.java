package br.univille.projprorim2024a.service;

import java.util.List;
import br.univille.projprorim2024a.entity.Cupon;

public interface CuponService {
    void save(Cupon usuario);
    Cupon getById(long id);
    List<Cupon> getAll();
    Cupon delete(long id);
}
