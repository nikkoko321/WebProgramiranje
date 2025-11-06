package mk.ukim.finki.wp.lab2.model;

import lombok.Data;

import java.util.List;

@Data
public class Chef {

    public Long id;
    public String firstName;
    public String lastName;
    public String bio;
    public List<Dish> dishes;

    public Chef(Long id, String firstName, String lastName, String bio, List<Dish> dishes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.dishes = dishes;
    }

}
