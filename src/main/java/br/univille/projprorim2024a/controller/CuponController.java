package br.univille.projprorim2024a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projprorim2024a.entity.Cupon;
import br.univille.projprorim2024a.service.CuponService;

@Controller
@RequestMapping("/cupons")
public class CuponController {

    @Autowired
    private CuponService service;

    @GetMapping
    public ModelAndView index() {
        var listaCupons = service.getAll();
        return new ModelAndView("cupon/index", "listaCupons", listaCupons);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cupon = new Cupon();
        return new ModelAndView("cupon/form", "cupon", cupon);
    }

    @PostMapping
    public ModelAndView save(Cupon cupon){
        service.save(cupon);
        return new ModelAndView("redirect:/cupons");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var cupon = service.getById(id);

        return new ModelAndView("cupon/form", "cupon", cupon);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);

        return new ModelAndView("redirect:/cupons");
    }
}
