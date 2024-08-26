package br.com.supermarketpetize.model.rest;

import br.com.supermarketpetize.model.entity.Order;
import br.com.supermarketpetize.model.rest.dto.OrderDTO;
import br.com.supermarketpetize.model.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supermaketpetize/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

  
    @Operation(summary = "Create new order")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

  
    @Operation(summary = "Update order status")
    @PutMapping("/{id}/status")
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrderStatus(@PathVariable Long id, @RequestBody String newStatus) {
        return orderService.updateOrderStatus(id, newStatus);
    }

   
    @Operation(summary = "List all orders")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> listAllOrders() {
        return orderService.listAllOrders();
    }

  
    @Operation(summary = "Search order by id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order searchById(@PathVariable Long id) {
        return orderService.searchById(id);
    }

    @Operation(summary = "Delete order by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
