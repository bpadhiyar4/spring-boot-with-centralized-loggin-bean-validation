package com.springpractical.bharat.controllers;

import com.springpractical.bharat.dtos.OrderRequestDTO;
import com.springpractical.bharat.dtos.OrderResponseDTO;
import com.springpractical.bharat.mappers.OrderMapper;
import com.springpractical.bharat.models.Order;
import com.springpractical.bharat.services.OrderService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : Bharat Padhiyar
 */
@RestController
@RequestMapping("/api/v1/orders/")
public class OrderController {

    private final OrderService orderService;
    private final Log log;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        this.log = LogFactory.getLog(OrderController.class);
    }

    @RequestMapping(value = "/place-order", method = RequestMethod.POST )
    public ResponseEntity<OrderResponseDTO> placeOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {

        Order order = orderService.placeOrder(orderRequestDTO);
        return ResponseEntity.ok(OrderMapper.convertToDTO(order));
    }
}