package demowithswiggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import demowithswiggy.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}