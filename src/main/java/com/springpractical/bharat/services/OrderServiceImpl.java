package com.springpractical.bharat.services;

import com.springpractical.bharat.dtos.OrderRequestDTO;
import com.springpractical.bharat.models.Order;
import com.springpractical.bharat.repositories.OrderRepository;
import com.springpractical.bharat.repositories.ProductRepository;
import com.springpractical.bharat.repositories.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author : Bharat Padhiyar
 * Implementation of {@link OrderService}.
 */
@Service
public class OrderServiceImpl implements OrderService{

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(ProductRepository productRepository, UserRepository userRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        Integer product = orderRequestDTO.getProductId();
        Integer user = orderRequestDTO.getUserId();
        order.setProduct(productRepository.getById(product));
        order.setUser(userRepository.getById(user));
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }
}
