package demowithswiggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import demowithswiggy.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}