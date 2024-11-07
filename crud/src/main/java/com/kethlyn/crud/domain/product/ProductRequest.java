package com.kethlyn.crud.domain.product;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, BigDecimal price) {

}
