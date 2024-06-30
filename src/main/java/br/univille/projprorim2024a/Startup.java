package br.univille.projprorim2024a;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projprorim2024a.entity.Cliente;
import br.univille.projprorim2024a.entity.Empresa;
import br.univille.projprorim2024a.entity.Usuario;
import br.univille.projprorim2024a.entity.Cidade;
import br.univille.projprorim2024a.service.ClienteService;
import br.univille.projprorim2024a.service.EmpresaService;
import br.univille.projprorim2024a.service.UsuarioService;
import br.univille.projprorim2024a.service.CidadeService;

@Component
public class Startup {
    @Autowired
    private ClienteService serviceCliente;

    @Autowired
    private UsuarioService serviceUsuario;

    @Autowired
    private EmpresaService serviceEmpresa;

    @Autowired
    private CidadeService serviceCidade;
    
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){

        var cliente1 = new Cliente();
        cliente1.setNome("Rafa");
        cliente1.setEndereco("Rua lalalalala 100");
        cliente1.setTipoUsuario("ADM");
        cliente1.setDataNascimento(new Date());
        serviceCliente.save(cliente1);

        var cidade1 = new Cidade();
        cidade1.setNome("Joinville");
        cidade1.setEstado("Santa Catarina");
        serviceCidade.save(cidade1);

        var cidade2 = new Cidade();
        cidade2.setNome("Toledo");
        cidade2.setEstado("Parana");
        serviceCidade.save(cidade2);


        var usuario1 = new Usuario();
        usuario1.setNome("Rafa GOD");
        usuario1.setSenhaUsu("12345");
        usuario1.setEndereco("Rua slaslasla 666");
        usuario1.setDataNascimento(new Date());
        serviceUsuario.save(usuario1);


        var empresa1 = new Empresa();
        empresa1.setNome("Wsys");
        empresa1.setCnpj("66 666 666/6666-66");
        empresa1.setEndereco("Rua do caralho 69");
        empresa1.setLink("https://www.wsys.inf.br/");
        empresa1.setDataNascimento(new Date());
        serviceEmpresa.save(empresa1);

    }
}
