package mk.ukim.finki.wp.lab2.service;

import mk.ukim.finki.wp.lab2.model.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DishService {
    List<Dish> listDishes();
    Dish findByDishId(String dishId);

    Dish findById(Long id);
    Dish create(String dishId, String name, String cuisine, int preparationTime);
    Dish update(Long id, String dishId, String name, String cuisine, int preparationTime);
    void delete(Long id);

    List<Dish> findAllByChefId(Long chefId);

}
