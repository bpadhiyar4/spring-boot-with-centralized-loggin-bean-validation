package com.springpractical.bharat.mappers;

import com.springpractical.bharat.dtos.OrderRequestDTO;
import com.springpractical.bharat.dtos.OrderResponseDTO;
import com.springpractical.bharat.models.Order;

/**
 * OrderMapper used to convert DTO to Model and vice-versa.
 */
public class OrderMapper {

    //TOOD: DTO to Model is not included for now.

    public static OrderResponseDTO convertToDTO(Order order) {
        OrderResponseDTO responseDTO = new OrderResponseDTO();
        responseDTO.setOrderId(order.getId());
        responseDTO.setProductId(order.getProduct().getId());
        responseDTO.setUserId(order.getUser().getId());
        responseDTO.setUserName(order.getUser().getUserName());
        responseDTO.setProductName(order.getProduct().getProductName());

        return responseDTO;
    }
}
