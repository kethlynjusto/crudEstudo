package com.kethlyn.crud.controllers;

import com.kethlyn.crud.domain.client.Client;
import com.kethlyn.crud.domain.client.ClientRepository;
import com.kethlyn.crud.domain.client.ClientRequest;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
