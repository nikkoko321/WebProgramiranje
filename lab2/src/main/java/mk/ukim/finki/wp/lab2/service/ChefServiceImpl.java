package mk.ukim.finki.wp.lab2.service;

import mk.ukim.finki.wp.lab2.model.Chef;
import mk.ukim.finki.wp.lab2.model.Dish;
import mk.ukim.finki.wp.lab2.repository.ChefRepository;
import mk.ukim.finki.wp.lab2.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChefServiceImpl implements ChefService {

    public final ChefRepository chefRepository;
    public final DishRepository chefDishRepository;

    public ChefServiceImpl(ChefRepository chefRepository, DishRepository chefDishRepository) {
        this.chefRepository = chefRepository;
        this.chefDishRepository = chefDishRepository;
    }

    @Override
    public List<Chef> listChefs() {
        return chefRepository.findAll();
    }

    @Override
    public Chef findById(Long id) {
        return chefRepository.findById(id).orElse(null);
    }

    @Override
    public Chef addDishToChef(Long chefId, String dishId) {
        Optional<Chef> chef = chefRepository.findById(chefId);
        if(chef.isPresent()) {
            Chef chef1 = chef.get();
            Dish dish = chefDishRepository.findByDishId(dishId);
            chef1.dishes.add(dish);
            chefRepository.save(chef1);
        }
        return chef.get();
    }


    @Override
    public Chef create(Long id, String firstName, String lastName, String bio, List<Dish> dishes) {
        return chefRepository.save(new Chef(id, firstName, lastName, bio, dishes));
    }


    @Override
    public Chef update(Long customId, Long id, String firstName, String lastName, String bio, List<Dish> dishes) {
        Chef d = chefRepository.findById(customId).orElseThrow();
        d.setFirstName(firstName);
        d.setLastName(lastName);
        d.setBio(bio);
        d.setId(id);
        return d;
    }

    @Override
    public void delete(Long id) {
        chefRepository.deleteById(id);
    }
}
