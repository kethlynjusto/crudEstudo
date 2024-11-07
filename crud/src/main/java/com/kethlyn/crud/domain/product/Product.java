package com.kethlyn.crud.domain.product;

import jakarta.persistence.*;
import lombok.*;

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
    private Integer price;

    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price = requestProduct.price();
    }

}
