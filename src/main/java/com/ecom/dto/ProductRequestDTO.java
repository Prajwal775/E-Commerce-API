package com.ecom.dto;

import com.ecom.Enumeration.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequestDTO {
    String productName;
    String description;
    BigDecimal price;
    Integer stock;
    Category category;
}
