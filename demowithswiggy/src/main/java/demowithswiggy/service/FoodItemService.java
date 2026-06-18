package demowithswiggy.service;

import java.util.List;
import demowithswiggy.entity.FoodItem;

public interface FoodItemService {

    FoodItem addFoodItem(FoodItem foodItem);

    List<FoodItem> getAllFoodItems();

    FoodItem getFoodItemById(Long id);
}