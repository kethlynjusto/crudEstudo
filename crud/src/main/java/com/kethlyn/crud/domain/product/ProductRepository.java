package com.kethlyn.crud.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;


    /* Essa interface define métodos para realizar operações comuns de persistência,
    como salvar, buscar, atualizar e excluir objetos de domínio em um banco de dados./*
     */
public interface ProductRepository extends JpaRepository<Product, String> {
                                                   //primary key, tipo que ela é

    //metodos como: findById, findAll, deleteAll, deleteById.
        //pode adicionar mais métodos tbm.
}




