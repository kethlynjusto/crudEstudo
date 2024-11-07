package com.kethlyn.crud.domain.endereco;

public record AddressRequest(String id, String rua, String numero, String complemento, String bairro,
                             String cidade, String estado, String cep) {
}
