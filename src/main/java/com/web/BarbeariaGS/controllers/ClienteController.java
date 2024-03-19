package com.web.BarbeariaGS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.BarbeariaGS.models.Cliente;
import com.web.BarbeariaGS.services.ClientesRepo;



@Controller
public class ClienteController {

     @Autowired
    private ClientesRepo repo;

     //Rota para página de cliente
    @GetMapping("/clientes")
    public String index(){
        return "clientes/index";
    }

     //Rota para página de cadastro de cliente
     @GetMapping("/clientes/novo")
     public String novo(){
         return "clientes/novo";
     }

     //Rota para metodo POST de cadastro de cliente
    @PostMapping("/clientes/criar")
    public String criar(Cliente cliente, @RequestParam String email){
         // Verifica se o e-mail já está em uso
         if (repo.existsByEmail(email)) {
            // Se o e-mail já está em uso, redireciona de volta para a página de cadastro com uma mensagem de erro
            return "redirect:/clientes/novo?error=emailInUse";
        }
        
        // Se o e-mail não está em uso, salva o cliente e redireciona para a página de clientes
        repo.save(cliente);
        return "redirect:/clientes";
    }
}
