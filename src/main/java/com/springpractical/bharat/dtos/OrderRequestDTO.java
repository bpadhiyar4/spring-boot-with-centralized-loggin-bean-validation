package com.springpractical.bharat.dtos;

import javax.validation.constraints.NotNull;

/**
 * OrderRequestDTO version 1.
 */
public class OrderRequestDTO {

    @NotNull(message = "Product Id should not be null")
    private Integer productId;

    @NotNull(message = "User Id should not be null")
    private Integer userId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
