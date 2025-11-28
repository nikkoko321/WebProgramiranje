package mk.ukim.finki.wp.lab2.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Dish {

    public String dishId;
    public String name;
    public String cuisine;
    public int preparationTime;
    public Long id;

    public Dish(){
        this.id = (long) (Math.random() * 1000);
    }

    public Dish(String dishId, String name, String cuisine, int preparationTime) {
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.id = (long) (Math.random() * 1000);
    }

}
