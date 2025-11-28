package mk.ukim.finki.wp.lab2.service;

import mk.ukim.finki.wp.lab2.model.Chef;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChefService {
    List<Chef> listChefs();
    Chef findById(Long id);
    Chef addDishToChef(Long chefId, String dishId);
}
