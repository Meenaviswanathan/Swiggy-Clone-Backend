package demowithswiggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import demowithswiggy.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}