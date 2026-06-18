package demowithswiggy.service;

import java.util.List;
import demowithswiggy.entity.Restaurant;

public interface RestaurantService {

    Restaurant addRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();
}