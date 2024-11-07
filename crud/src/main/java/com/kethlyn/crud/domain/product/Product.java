package com.kethlyn.crud.domain.product;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "product")
@Entity(name = "product")
@EqualsAndHashCode(of = "id")
@Data   // igual usar getter e setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    //para valor o melhor é colocar bigdecimal e setar a precisao e escala, no SQL cria como decimal
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    private Boolean active;

    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price = requestProduct.price();
        this.active = true;
    }

}
