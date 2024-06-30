package br.univille.projprorim2024a.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projprorim2024a.service.CuponService;
import br.univille.projprorim2024a.service.EmpresaService;

@Controller
@RequestMapping("/usarcupons")
public class UsarCuponController {

    @Autowired
    private CuponService service;
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ModelAndView index() {
        var listaCupons = service.getAll();
        return new ModelAndView("usarcupon/index", "listaCupons", listaCupons);
    }

    @GetMapping("/info/{id}")
    public ModelAndView info(@PathVariable("id") long id){
        var empresa = empresaService.getById(id);
        var listaCuponsPorEmpresa = service.getCuponByEmpresa(empresa);
        
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("listaCuponsPorEmpresa",listaCuponsPorEmpresa);
        dados.put("empresa",empresa);

        return new ModelAndView("usarcupon/indexEmpresas", dados);
    }
}
