package com.ebay.dto;


import lombok.Data;

@Data
public class CartDTO {
    private String productId;
    private Integer ProductQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        ProductQuantity = productQuantity;
    }
}
