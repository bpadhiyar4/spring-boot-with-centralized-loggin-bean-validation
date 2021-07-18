package com.springpractical.bharat.services;

import com.springpractical.bharat.dtos.OrderRequestDTO;
import com.springpractical.bharat.models.Order;

/**
 * Order Service which contains the method to perform order related task.
 */
public interface OrderService {

    /**
     * Used to create the new order.
     * @param order {@link OrderRequestDTO}
     * @return {@link Order}
     */
    Order placeOrder(OrderRequestDTO order);

    /**
     * Used to delete the order.
     * @param orderId
     */
    void deleteOrder(Integer orderId);
}
