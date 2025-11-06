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
        Chef chefFinal = DataHolder.chefs.stream().filter(chef -> chef.id.equals(id)).findFirst().orElse(null);
        return Optional.ofNullable(chefFinal);
    }

    @Override
    public Chef save(Chef chef) {
        Chef chefFinal = DataHolder.chefs.stream().filter(temp -> temp.equals(chef)).findFirst().orElse(null);
        if(chefFinal != null) {
            DataHolder.chefs.remove(chefFinal);
            DataHolder.chefs.add(chef);
        }
        else{
            DataHolder.chefs.add(chef);
        }
        return chef;
    }
}
