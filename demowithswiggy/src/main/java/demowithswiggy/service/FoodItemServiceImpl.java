package demowithswiggy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demowithswiggy.entity.FoodItem;
import demowithswiggy.entity.Restaurant;
import demowithswiggy.repository.FoodItemRepository;
import demowithswiggy.repository.RestaurantRepository;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    @Autowired
    private FoodItemRepository repo;

    @Autowired
    private RestaurantRepository restaurantRepo;

    public FoodItem addFoodItem(FoodItem foodItem) {

        Long id = foodItem.getRestaurant().getId();

        Restaurant restaurant = restaurantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        foodItem.setRestaurant(restaurant);

        return repo.save(foodItem);
    }

    public List<FoodItem> getAllFoodItems() {
        return repo.findAll();
    }

    public FoodItem getFoodItemById(Long id) {
        return repo.findById(id).orElse(null);
    }
}