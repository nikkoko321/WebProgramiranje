package mk.ukim.finki.wp.lab2.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab2.model.Chef;
import mk.ukim.finki.wp.lab2.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init(){
        dishes.add(new Dish("#aad331", "Supa", "blaa", 30));
        dishes.add(new Dish("#aad32131", "Salama", "blaa", 20));
        dishes.add(new Dish("#331", "Jajca", "akajgana", 50));
        chefs.add(new Chef(232L, "Nikola", "asdad", "biogradsdaa  ads", dishes));
        chefs.add(new Chef(2369102L, "marsa", "reprez", "biodaa  ads", dishes));
    }

}
