package br.univille.projprorim2024a.service;

import java.util.List;
import br.univille.projprorim2024a.entity.Usuario;

public interface UsuarioService {
    void save(Usuario usuario);
    Usuario getById(long id);
    List<Usuario> getAll();
    Usuario delete(long id);
}
