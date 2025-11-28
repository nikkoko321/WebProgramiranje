package mk.ukim.finki.wp.lab2.repository;

import mk.ukim.finki.wp.lab2.model.Chef;
import mk.ukim.finki.wp.lab2.model.Dish;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ChefRepository {
    List<Chef> findAll();
    Optional<Chef> findById(Long id);
    Chef save(Chef chef);
    void deleteById(Long id);
}