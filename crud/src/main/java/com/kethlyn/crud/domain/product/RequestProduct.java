package com.kethlyn.crud.domain.product;

import jakarta.validation.constraints.NotEmpty;

public record RequestProduct(String id,String name,Integer price) {

}
