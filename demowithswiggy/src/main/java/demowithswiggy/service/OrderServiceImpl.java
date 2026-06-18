package demowithswiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demowithswiggy.entity.*;
import demowithswiggy.repository.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private FoodItemRepository foodRepo;

    @Autowired
    private DeliveryPartnerRepository partnerRepo;

    // ================= PLACE ORDER =================
    @Override
    public Order placeOrder(Long userId, List<Long> foodIds) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<FoodItem> foods = foodRepo.findAllById(foodIds);

        if (foods.isEmpty()) {
            throw new RuntimeException("Food not found");
        }

        double total = 0;
        for (FoodItem f : foods) {
            total += f.getPrice();
        }

        Order order = new Order();
        order.setUser(user);
        order.setFoodItems(foods);
        order.setTotalAmount(total);
        order.setStatus("PLACED");

        return orderRepo.save(order);
    }

    // ================= GET ALL ORDERS =================
    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    // ================= GET BY ID =================
    @Override
    public Order getOrderById(Long id) {
        return orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // ================= ASSIGN DELIVERY =================
    @Override
    public Order assignDelivery(Long orderId, Long partnerId) {

        Order order = getOrderById(orderId);

        DeliveryPartner partner = partnerRepo.findById(partnerId)
                .orElseThrow(() -> new RuntimeException("Delivery partner not found"));

        if (!"AVAILABLE".equalsIgnoreCase(partner.getStatus())) {
            throw new RuntimeException("Partner is busy");
        }

        order.setDeliveryPartner(partner);
        order.setStatus("OUT_FOR_DELIVERY");

        partner.setStatus("BUSY");
        partnerRepo.save(partner);

        return orderRepo.save(order);
    }

    // ================= UPDATE STATUS =================
    @Override
    public Order updateStatus(Long orderId, String status) {

        Order order = getOrderById(orderId);

        String upperStatus = status.toUpperCase();

        if (!upperStatus.equals("PLACED") &&
            !upperStatus.equals("OUT_FOR_DELIVERY") &&
            !upperStatus.equals("DELIVERED")) {

            throw new RuntimeException("Invalid status");
        }

        order.setStatus(upperStatus);

        // If delivered → free partner
        if (upperStatus.equals("DELIVERED") && order.getDeliveryPartner() != null) {

            DeliveryPartner partner = order.getDeliveryPartner();
            partner.setStatus("AVAILABLE");

            partnerRepo.save(partner);
        }

        return orderRepo.save(order);
    }
}