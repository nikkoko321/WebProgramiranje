package mk.ukim.finki.wp.lab2.service;

import mk.ukim.finki.wp.lab2.model.Dish;
import mk.ukim.finki.wp.lab2.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    public final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> listDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findByDishId(String dishId) {
        return dishRepository.findByDishId(dishId);
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id).get();
    }

    @Override
    public Dish create(String dishId, String name, String cuisine, int preparationTime) {
        return dishRepository.save(new Dish(dishId, name, cuisine, preparationTime));
    }

    @Override
    public Dish update(Long id, String dishId, String name, String cuisine, int preparationTime) {
        Dish d = new Dish(dishId, name, cuisine, preparationTime);
        d.id = id;
        return dishRepository.save(d);
    }

    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }
}
