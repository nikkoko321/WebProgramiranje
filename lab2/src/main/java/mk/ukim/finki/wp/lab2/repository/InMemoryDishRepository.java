//package mk.ukim.finki.wp.lab2.repository;
//
//import mk.ukim.finki.wp.lab2.bootstrap.DataHolder;
//import mk.ukim.finki.wp.lab2.model.Dish;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Repository
//public class InMemoryDishRepository implements DishRepository {
//
//    @Override
//    public List<Dish> findAll() {
//        return DataHolder.dishes;
//    }
//
//    @Override
//    public Dish findByDishId(String dishId) {
//        return DataHolder.dishes.stream().filter(dish -> dish.dishId.equals(dishId)).findFirst().orElse(null);
//    }
//
//    @Override
//    public Optional<Dish> findById(Long id) {
//        for(Dish dish : DataHolder.dishes) {
//            if(dish.id.equals(id)) {
//                return Optional.of(dish);
//            }
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public Dish save(Dish dish) {
//        DataHolder.dishes.removeIf(i -> i.dishId.equals(dish.dishId));
//        DataHolder.dishes.add(dish);
//        return dish;
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        DataHolder.dishes.removeIf(d -> d.id.equals(id));
//    }
//
//
//}
