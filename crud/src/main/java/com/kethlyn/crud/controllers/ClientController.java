package com.kethlyn.crud.controllers;

import com.kethlyn.crud.domain.client.Client;
import com.kethlyn.crud.domain.client.ClientRepository;
import com.kethlyn.crud.domain.client.ClientRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClient(){
        List<Client> allClients = clientRepository.findAll();
        return ResponseEntity.ok(allClients);
    }

    @PostMapping
    public ResponseEntity addClient(@RequestBody @Valid ClientRequest data){
        Client client = new Client(data);
        clientRepository.save(client);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateClient(@PathVariable String id, @RequestBody @Valid ClientRequest data){
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()){
            Client client = optionalClient.get();
            client.setEmail(data.email());
            client.setTelefone(data.telefone());

            client = clientRepository.save(client);
            return ResponseEntity.ok(client);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteClient(@PathVariable String id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isPresent()){
            Client client = optionalClient.get();
            clientRepository.delete(client);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
