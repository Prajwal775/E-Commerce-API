package com.ecom.dto;

import com.ecom.Enumeration.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDTO {
    Long productId;
    String productName;
    String description;
    BigDecimal price;
    Integer stock;
    Category category;
}
