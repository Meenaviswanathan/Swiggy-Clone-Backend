package demowithswiggy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import demowithswiggy.entity.Restaurant;
import demowithswiggy.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repo;

    public RestaurantServiceImpl(RestaurantRepository repo) {
        this.repo = repo;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return repo.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return repo.findAll();
    }
}