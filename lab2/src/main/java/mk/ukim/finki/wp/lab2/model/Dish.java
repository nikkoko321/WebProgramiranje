package mk.ukim.finki.wp.lab2.model;

import lombok.Data;

@Data
public class Dish {

    public String dishId;
    public String name;
    public String cuisine;
    public int preparationTime;

    public Dish(String dishId, String name, String cuisine, int preparationTime) {
        this.dishId = dishId;
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
    }
}
