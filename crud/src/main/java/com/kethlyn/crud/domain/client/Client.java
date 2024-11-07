package com.kethlyn.crud.domain.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Table(name = "client")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String telefone;

    public Client(ClientRequest clientRequest){
        this.name = clientRequest.name();
        this.email = clientRequest.email();
        this.telefone = clientRequest.telefone();
        //BeanUtils.copyProperties(this, clientRequest);
    }
}
