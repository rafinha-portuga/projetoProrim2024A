package br.univille.projprorim2024a;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projprorim2024a.entity.Cliente;
import br.univille.projprorim2024a.entity.Empresa;
import br.univille.projprorim2024a.entity.Usuario;
import br.univille.projprorim2024a.service.ClienteService;
import br.univille.projprorim2024a.service.EmpresaService;
import br.univille.projprorim2024a.service.UsuarioService;

@Component
public class Startup {
    @Autowired
    private ClienteService serviceCliente;

    @Autowired
    private UsuarioService serviceUsuario;

    @Autowired
    private EmpresaService serviceEmpresa;
    
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){

        var cliente1 = new Cliente();
        cliente1.setNome("Rafa");
        cliente1.setEndereco("Rua lalalalala 100");
        cliente1.setDataNascimento(new Date());
        serviceCliente.save(cliente1);


        var usuario1 = new Usuario();
        usuario1.setNome("Rafa GOD");
        usuario1.setTpUsuario("ADM");
        usuario1.setEndereco("Rua slaslasla 666");
        usuario1.setDataNascimento(new Date());
        serviceUsuario.save(usuario1);


        var empresa1 = new Empresa();
        empresa1.setNome("Wsys");
        empresa1.setCnpj("59 456 277/0001-76");
        empresa1.setEndereco("Rua felipe camarão 71");
        empresa1.setDataNascimento(new Date());
        serviceEmpresa.save(empresa1);

    }
}
