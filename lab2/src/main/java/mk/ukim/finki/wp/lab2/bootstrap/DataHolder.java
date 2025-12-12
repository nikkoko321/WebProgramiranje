package mk.ukim.finki.wp.lab2.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab2.model.Chef;
import mk.ukim.finki.wp.lab2.model.Dish;
import mk.ukim.finki.wp.lab2.repository.ChefRepository;
import mk.ukim.finki.wp.lab2.repository.DishRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Chef> chefs = null;
    public static List<Dish> dishes = null;
    private final DishRepository dishRepository;
    private final ChefRepository chefRepository;

    public DataHolder(DishRepository dishRepository, ChefRepository chefRepository) {
        this.dishRepository = dishRepository;
        this.chefRepository = chefRepository;
    }

    @PostConstruct
    public void init(){

        if (dishRepository.findAll().isEmpty()) {
            dishes = new ArrayList<>();
            dishes.add(new Dish("#aad331", "Pasta Carbonara", "blaa", 30));
            dishes.add(new Dish("#aad32131", "Beef Wellington", "blaa", 20));
            dishes.add(new Dish("#331", "Chicken Tikka Masala", "akajgana", 50));
            dishRepository.saveAll(dishes);
        }

        if (chefRepository.findAll().isEmpty()) {
            chefs = new ArrayList<>();
            chefs.add(new Chef("Jamie", "Oliver", "Bio od Oliver", new ArrayList<>()));
            chefs.add(new Chef("Gordon", "Ramsy", "Bio of Ramsy", new ArrayList<>()));
            chefRepository.saveAll(chefs);
        }


    }

}
