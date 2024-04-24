package br.univille.projprorim2024a;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projprorim2024a.entity.Cliente;
import br.univille.projprorim2024a.service.ClienteService;

@Component
public class Startup {
    @Autowired
    private ClienteService service;
    
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){

        var cliente1 = new Cliente();
        cliente1.setNome("Rafa");
        cliente1.setEndereco("Rua lalalalala 100");
        cliente1.setDataNascimento(new Date());
        service.save(cliente1);

    }
}
