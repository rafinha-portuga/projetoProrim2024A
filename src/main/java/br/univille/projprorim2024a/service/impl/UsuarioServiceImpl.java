package br.univille.projprorim2024a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projprorim2024a.entity.Usuario;
import br.univille.projprorim2024a.repository.UsuarioRepository;
import br.univille.projprorim2024a.service.UsuarioService;

@Service
public class UsuarioServiceImpl 
    implements UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;
    
    @Override
    public void save(Usuario cliente) {
        repository.save(cliente);
    }

    @Override
    public Usuario getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public Usuario delete(long id) {
        var cliente = getById(id);
        repository.deleteById(id);
        return cliente;
    }
    
}
