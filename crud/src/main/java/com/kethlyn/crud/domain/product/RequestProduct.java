package com.kethlyn.crud.domain.product;

import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record RequestProduct(String id, String name, BigDecimal price) {

}
