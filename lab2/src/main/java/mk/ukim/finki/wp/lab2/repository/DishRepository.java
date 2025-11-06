package mk.ukim.finki.wp.lab2.repository;

import mk.ukim.finki.wp.lab2.model.Dish;

import java.util.List;

public interface DishRepository {
    List<Dish> findAll();
    Dish findByDishId(String dishId);
}
