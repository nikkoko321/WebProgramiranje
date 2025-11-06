package mk.ukim.finki.wp.lab2.service;

import mk.ukim.finki.wp.lab2.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> listDishes();
    Dish findByDishId(String dishId);
}
