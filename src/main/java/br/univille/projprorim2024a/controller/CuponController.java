package br.univille.projprorim2024a.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projprorim2024a.entity.Cupon;
import br.univille.projprorim2024a.service.CuponService;
import br.univille.projprorim2024a.service.EmpresaService;

@Controller
@RequestMapping("/cupons")
public class CuponController {

    @Autowired
    private CuponService service;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ModelAndView index() {
        var listaCupons = service.getAll();
        return new ModelAndView("cupon/index", "listaCupons", listaCupons);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        HashMap<String,Object> dados = new HashMap<>();
        var novoCupon = new Cupon();
        var listaEmpresas = empresaService.getAll();

        dados.put("cupon",novoCupon);
        dados.put("listaEmpresas",listaEmpresas);

        return new ModelAndView("cupon/form", dados);
    }

    @PostMapping
    public ModelAndView save(Cupon cupon){
        service.save(cupon);
        return new ModelAndView("redirect:/cupons");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Cupon cupon){

        HashMap<String,Object> dados = new HashMap<>();
        var listaEmpresas = empresaService.getAll();
        dados.put("cupon",cupon);
        dados.put("listaEmpresas",listaEmpresas);
        

        return new ModelAndView("cupon/form",dados);
    }

    @GetMapping("/alterarCupomEmpresa/{id}")
    public ModelAndView alterarCupomEmpresa(@PathVariable("id") Cupon cupon){

        HashMap<String,Object> dados = new HashMap<>();
        var listaEmpresas = empresaService.getAll();
        dados.put("cupon",cupon);
        dados.put("listaEmpresas",listaEmpresas);
        

        return new ModelAndView("cupon/formEmpresa",dados);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);

        return new ModelAndView("redirect:/cupons");
    }
}
