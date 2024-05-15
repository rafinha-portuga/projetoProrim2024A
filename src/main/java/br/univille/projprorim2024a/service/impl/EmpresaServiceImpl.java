package br.univille.projprorim2024a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projprorim2024a.entity.Empresa;
import br.univille.projprorim2024a.repository.EmpresaRepository;
import br.univille.projprorim2024a.service.EmpresaService;

@Service
public class EmpresaServiceImpl 
    implements EmpresaService {
    
    @Autowired
    private EmpresaRepository repository;
    
    @Override
    public void save(Empresa cliente) {
        repository.save(cliente);
    }

    @Override
    public Empresa getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Empresa> getAll() {
        return repository.findAll();
    }

    @Override
    public Empresa delete(long id) {
        var cliente = getById(id);
        repository.deleteById(id);
        return cliente;
    }
    
}
