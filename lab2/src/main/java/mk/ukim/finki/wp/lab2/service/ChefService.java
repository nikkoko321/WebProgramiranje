package mk.ukim.finki.wp.lab2.service;

import mk.ukim.finki.wp.lab2.model.Chef;
import mk.ukim.finki.wp.lab2.model.Dish;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChefService {
    List<Chef> listChefs();
    Chef findById(Long id);
    Chef addDishToChef(Long chefId, Long id);

    Chef create(String firstName, String lastName, String bio, List<Dish> dishes);
    Chef update(Long id, String firstName, String lastName, String bio, List<Dish> dishes);
    void delete(Long id);
}
