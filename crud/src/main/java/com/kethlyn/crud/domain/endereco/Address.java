package com.kethlyn.crud.domain.endereco;

import com.kethlyn.crud.domain.client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Table(name = "address")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id")
    private Client client;

    public Address(AddressRequest addressRequest){
        //para passar tudo de uma vez e não precisar fazer 1 por 1.
        //this.rua = addressRequest.rua();
        BeanUtils.copyProperties(this, addressRequest);
    }

}


