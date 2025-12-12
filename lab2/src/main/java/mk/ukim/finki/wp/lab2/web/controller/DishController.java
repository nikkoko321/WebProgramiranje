package mk.ukim.finki.wp.lab2.web.controller;


import mk.ukim.finki.wp.lab2.model.Chef;
import mk.ukim.finki.wp.lab2.model.Dish;
import mk.ukim.finki.wp.lab2.service.ChefService;
import mk.ukim.finki.wp.lab2.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
public class DishController {

    public final DishService dishService;
    public final ChefService chefService;

    public DishController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @GetMapping("/dishes")
    public String getDishesPage(
            @RequestParam(required = false)
            String error,
            Model model){

        if (error != null) {
            model.addAttribute("error", error);
        }

        model.addAttribute("dishes", dishService.listDishes());

        return "listDishes";
    }

    @PostMapping("/dishes")
    public String saveDish(@RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime){

        dishService.create(dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";

    }


    @PostMapping("/dishes/edit/{id}")
    public String editDish(@PathVariable Long id,
                           @RequestParam String dishId,
                           @RequestParam String name,
                           @RequestParam String cuisine,
                           @RequestParam int preparationTime){

        dishService.update(id, dishId, name, cuisine, preparationTime);
        return "redirect:/dishes";

    }


    @GetMapping("/dishes/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        return "redirect:/dishes/dish-form/" + id;
    }



    @PostMapping("/dishes/delete/{id}")
    public String deleteDish(@PathVariable Long id){
        dishService.delete(id);
        return "redirect:/dishes";
    }

    @GetMapping("/dishes/dish-form/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model){
        if(dishService.findById(id) == null) {
            return "redirect:/dishes?error=DishNotFound";
        }
        model.addAttribute("dish", dishService.findById(id));
        return "dish-form";
    }

    @GetMapping("/dishes/dish-form")
    public String getAddDishPage(Model model){
        return "dish-form";
    }

    @GetMapping("/listChefs")
    public String chefList(Model model){
        model.addAttribute("chefs", chefService.listChefs());
        return "listChefs";
    }

    @PostMapping("/dish")
    public String dishServl(Model model, @RequestParam String id){
        model.addAttribute("dishes", dishService.listDishes());
        model.addAttribute("chefId", id);
        Chef chef = chefService.findById(Long.parseLong(id));
        String name = chef.firstName;
        model.addAttribute("chefName", name);

        return "dishesList";
    }

    @PostMapping("/chefDetails")
    public String chefDetails(Model model, @RequestParam String chefId, @RequestParam Long dishId){

        Chef chef = chefService.findById(Long.parseLong(chefId));

        chefService.addDishToChef(Long.parseLong(chefId), dishId);
        model.addAttribute("ime", chef.firstName);
        model.addAttribute("bio", chef.bio);
        model.addAttribute("dishes", chef.dishes);

        return "chefDetails";
    }

}
