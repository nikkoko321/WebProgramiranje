package mk.ukim.finki.wp.lab2.repository;

import mk.ukim.finki.wp.lab2.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAll();
    Dish findByDishId(String dishId);

    Optional<Dish> findById(Long id);
    Dish save(Dish dish);
    void deleteById(Long id);

    List<Dish> findAllByChef_Id(Long chefId);
}
