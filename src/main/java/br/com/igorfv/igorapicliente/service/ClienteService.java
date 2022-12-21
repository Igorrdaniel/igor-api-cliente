package br.com.igorfv.igorapicliente.service;

import br.com.igorfv.igorapicliente.model.Cliente;
import br.com.igorfv.igorapicliente.repositoy.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    public List<Cliente> buscar(){
        return clienteRepository.findAll();
    }

    public Cliente buscarId(@PathVariable Cliente clienteid){
        return clienteRepository.findById(clienteid.getId()).get();
    }


    public Cliente cadastrar(@RequestBody Cliente dados){
        return clienteRepository.save(dados);
    }

    public Cliente atualizar(@RequestBody Cliente dados){
           return clienteRepository.save(dados);

    }

    @Transactional
    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }

}
