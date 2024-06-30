package br.univille.projprorim2024a.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projprorim2024a.entity.Empresa;
import br.univille.projprorim2024a.service.EmpresaService;
import br.univille.projprorim2024a.service.SalvarArquivosService;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService service;
    @Autowired
    private SalvarArquivosService salvarArquivoService;

    @GetMapping
    public ModelAndView index() {
        var listaEmpresas = service.getAll();
        return new ModelAndView("empresa/index", "listaEmpresas", listaEmpresas);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var empresa = new Empresa();
        return new ModelAndView("empresa/form", "empresa", empresa);
    }

    @PostMapping
    public ModelAndView save(Empresa empresa, @RequestParam("file") MultipartFile file){
        if(file.getSize() != 0){
            String caminho = salvarArquivoService.save(file);
            empresa.setFoto(caminho);
        }
        service.save(empresa);
        return new ModelAndView("redirect:/empresas");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id){
        var empresa = service.getById(id);

        return new ModelAndView("empresa/form", "empresa", empresa);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);

        return new ModelAndView("redirect:/empresas");
    }

    @GetMapping(value = "/image/{id}")
    public @ResponseBody byte[] getImage(@PathVariable("id") Empresa empresa){
        try{
            File file = new File(empresa.getFoto());
            byte[] bytes = new byte[(int) file.length()];
            try(DataInputStream dis = new DataInputStream(new FileInputStream(file));){
                dis.readFully(bytes);
            }
            return bytes;
        }catch (Exception e){
            return new byte[0];
        }
    }
}
