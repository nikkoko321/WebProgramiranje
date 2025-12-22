package mk.ukim.finki.wp.lab2.service;

import jakarta.transaction.Transactional;
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
    @Transactional
    public Chef addDishToChef(Long chefId, Long id) {
        Optional<Chef> chef = chefRepository.findById(chefId);
        if(chef.isPresent()) {
            Chef chef1 = chef.get();
            Dish dish = chefDishRepository.findById(id).get();
            dish.chef = chef1;
            chefRepository.save(chef1);
        }
        return chef.get();
    }


    @Override
    public Chef create(String firstName, String lastName, String bio, List<Dish> dishes) {
        return chefRepository.save(new Chef(firstName, lastName, bio, dishes));
    }


    @Override
    public Chef update(Long id, String firstName, String lastName, String bio, List<Dish> dishes) {
        Chef d = chefRepository.findById(id).orElseThrow();
        d.firstName = firstName;
        d.lastName = lastName;
        d.bio = bio;
        chefRepository.save(d);
        return d;
    }

    @Override
    public void delete(Long id) {
        chefRepository.deleteById(id);
    }
}
