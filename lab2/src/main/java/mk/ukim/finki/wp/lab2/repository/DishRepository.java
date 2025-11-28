package mk.ukim.finki.wp.lab2.repository;

import mk.ukim.finki.wp.lab2.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository {
    List<Dish> findAll();
    Dish findByDishId(String dishId);

    Optional<Dish> findById(Long id);
    Dish save(Dish dish);
    void deleteById(Long id);
}
