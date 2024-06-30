package br.univille.projprorim2024a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projprorim2024a.entity.Cupon;
import br.univille.projprorim2024a.entity.Empresa;
import br.univille.projprorim2024a.repository.CuponRepository;
import br.univille.projprorim2024a.service.CuponService;

@Service
public class CuponServiceImpl 
    implements CuponService {
    
    @Autowired
    private CuponRepository repository;
    
    @Override
    public void save(Cupon cliente) {
        repository.save(cliente);
    }

    @Override
    public Cupon getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Cupon> getAll() {
        return repository.findAll();
    }

    @Override
    public Cupon delete(long id) {
        var cliente = getById(id);
        repository.deleteById(id);
        return cliente;
    }

    @Override
    public List<Cupon> getCuponByEmpresa(Empresa empresa) {
        return repository.getCuponByEmpresa(empresa);
    }
    
}
