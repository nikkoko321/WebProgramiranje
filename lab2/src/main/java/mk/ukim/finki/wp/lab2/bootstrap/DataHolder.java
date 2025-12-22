package mk.ukim.finki.wp.lab2.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab2.model.Chef;
import mk.ukim.finki.wp.lab2.model.Dish;
import mk.ukim.finki.wp.lab2.model.Role;
import mk.ukim.finki.wp.lab2.model.User;
import mk.ukim.finki.wp.lab2.repository.ChefRepository;
import mk.ukim.finki.wp.lab2.repository.DishRepository;
import mk.ukim.finki.wp.lab2.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Chef> chefs = null;
    public static List<Dish> dishes = null;
    private final DishRepository dishRepository;
    private final ChefRepository chefRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public DataHolder(DishRepository dishRepository, ChefRepository chefRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.dishRepository = dishRepository;
        this.chefRepository = chefRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init(){

        if (userRepository.count() == 0) {
            userRepository.save(new User(
                    "user",
                    passwordEncoder.encode("user"),
                    "u1",
                    "surU1",
                    Role.ROLE_USER
            ));

            userRepository.save(new User(
                    "admin",
                    passwordEncoder.encode("admin"),
                    "Admin",
                    "Admin",
                    Role.ROLE_ADMIN
            ));
        }

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