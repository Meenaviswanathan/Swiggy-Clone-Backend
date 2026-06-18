package demowithswiggy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demowithswiggy.entity.FoodItem;
import demowithswiggy.service.FoodItemService;

@RestController
@RequestMapping("/fooditems")
public class FoodItemController {

    private final FoodItemService service;

    public FoodItemController(FoodItemService service) {
        this.service = service;
    }

    @PostMapping
    public FoodItem add(@RequestBody FoodItem foodItem) {
        return service.addFoodItem(foodItem);
    }

    @GetMapping
    public List<FoodItem> getAll() {
        return service.getAllFoodItems();
    }

    @GetMapping("/{id}")
    public FoodItem getById(@PathVariable Long id) {
        return service.getFoodItemById(id);
    }
}