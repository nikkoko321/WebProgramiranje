package mk.ukim.finki.wp.lab2.repository;

import mk.ukim.finki.wp.lab2.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab2.model.Chef;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryChefRepository implements ChefRepository {


    @Override
    public List<Chef> findAll() {
        return DataHolder.chefs;
    }

    @Override
    public Optional<Chef> findById(Long id) {
        Chef chefFinal = DataHolder.chefs.stream().filter(chef -> chef.customId.equals(id)).findFirst().orElse(null);
        return Optional.ofNullable(chefFinal);
    }

    @Override
    public Chef save(Chef chef) {
        DataHolder.chefs.removeIf(i -> i.id.equals(chef.id));
        DataHolder.chefs.add(chef);
        return chef;
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.chefs.removeIf(d -> d.customId.equals(id));
    }
}
