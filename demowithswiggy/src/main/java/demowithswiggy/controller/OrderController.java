package demowithswiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import demowithswiggy.entity.Order;
import demowithswiggy.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public Order placeOrder(@PathVariable Long userId,
                            @RequestBody List<Long> foodIds) {
        return orderService.placeOrder(userId, foodIds);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/{orderId}/assign/{partnerId}")
    public Order assignDelivery(@PathVariable Long orderId,
                                @PathVariable Long partnerId) {
        return orderService.assignDelivery(orderId, partnerId);
    }

    @PutMapping("/{orderId}/status")
    public Order updateStatus(@PathVariable Long orderId,
                              @RequestParam String status) {
        return orderService.updateStatus(orderId, status);
    }
}