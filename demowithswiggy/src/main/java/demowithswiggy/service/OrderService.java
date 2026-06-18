package demowithswiggy.service;

import java.util.List;
import demowithswiggy.entity.Order;

public interface OrderService {

    Order placeOrder(Long userId, List<Long> foodIds);

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order assignDelivery(Long orderId, Long partnerId);

    Order updateStatus(Long orderId, String status);
}