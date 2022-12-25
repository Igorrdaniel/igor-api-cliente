package br.com.igorfv.igorapicliente.controller;

import br.com.igorfv.igorapicliente.model.Cliente;
import br.com.igorfv.igorapicliente.repositoy.ClienteRepository;
import br.com.igorfv.igorapicliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public List<Cliente> buscar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteid}")
    public ResponseEntity<Cliente> buscarId(@PathVariable Long clienteid) {
        return clienteRepository.findById(clienteid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return clienteService.cadastrar(cliente);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Cliente> deletar(@Valid @PathVariable Long id){
       if (!clienteRepository.existsById(id)){
           return ResponseEntity.notFound().build();
       }
       clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
