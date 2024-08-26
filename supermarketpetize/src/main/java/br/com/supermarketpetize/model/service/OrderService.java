package br.com.supermarketpetize.model.service;

import br.com.supermarketpetize.model.entity.Order;
import br.com.supermarketpetize.model.entity.OrderStatus;
import br.com.supermarketpetize.model.entity.Product;
import br.com.supermarketpetize.model.repository.OrderRepository;
import br.com.supermarketpetize.model.repository.ProductRepository;
import br.com.supermarketpetize.model.rest.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderStatusMessageSender orderStatusMessageSender;

    public Order createOrder(OrderDTO dto) {
        List<Product> products = dto.getId_product().stream()
                .map(id -> productRepository.findById(Long.parseLong(id))
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado com ID: " + id)))
                .collect(Collectors.toList());
        Integer quantity = Integer.parseInt(dto.getQuantity());
        Order order = new Order();
        order.setProducts(products);
        order.setQuantity(quantity);
        order.setOrderDate(LocalDate.now());
        String status = dto.getOrderStatus().toUpperCase();
        order.setOrderStatus(OrderStatus.valueOf(status));
        return orderRepository.save(order);
    }
    
    public Order updateOrderStatus(Long orderId, String newStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));

        try {
            System.out.println("Novo status recebido: '" + newStatus + "'");
            OrderStatus statusEnum = OrderStatus.valueOf(newStatus.trim().toUpperCase());
            order.setOrderStatus(statusEnum);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status inválido: " + newStatus);
        }

        orderRepository.save(order);
        orderStatusMessageSender.sendOrderStatusUpdateMessage(orderId, newStatus);

        return order;
    }



  
    public List<Order> listAllOrders() {
        return orderRepository.findAll();
    }


    public Order searchById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
    }

  
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        
        orderRepository.delete(order);
    }
}
