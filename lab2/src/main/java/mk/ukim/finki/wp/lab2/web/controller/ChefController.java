package mk.ukim.finki.wp.lab2.web.controller;

import mk.ukim.finki.wp.lab2.model.Chef;
import mk.ukim.finki.wp.lab2.model.Dish;
import mk.ukim.finki.wp.lab2.service.ChefService;
import mk.ukim.finki.wp.lab2.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ChefController {

    public final DishService dishService;
    public final ChefService chefService;

    public ChefController(DishService dishService, ChefService chefService) {
        this.dishService = dishService;
        this.chefService = chefService;
    }

    @GetMapping("/chefs")
    public String getDishesPage(
            @RequestParam(required = false)
            String error,
            Model model){

        if (error != null) {
            model.addAttribute("error", error);
        }

        model.addAttribute("chefs", chefService.listChefs());

        return "listChefs2";
    }

    @PostMapping("/chefs")
    public String saveDish(@RequestParam Long id,
                           @RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String bio){

        chefService.create(id,  firstName,  lastName,  bio, new ArrayList<>());
        return "redirect:/chefs";

    }


    @PostMapping("/chefs/edit/{customId}")
    public String editDish(@PathVariable Long customId,
                           @RequestParam Long id,
                           @RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String bio){

        chefService.update(customId,  id,  firstName,  lastName,  bio, chefService.findById(customId).dishes);
        return "redirect:/chefs";

    }


    @PostMapping("/chefs/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {
        return "redirect:/chefs/chef-form/" + id;
    }



    @PostMapping("/chefs/delete/{id}")
    public String deleteDish(@PathVariable Long id){
        chefService.delete(id);
        return "redirect:/chefs";
    }

    @GetMapping("/chefs/chef-form/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model){
        if(chefService.findById(id) == null) {
            return "redirect:/chefs?error=ChefNotFound";
        }
        model.addAttribute("chef", chefService.findById(id));
        return "chef-form";
    }

    @GetMapping("/chefs/chef-form")
    public String getAddDishPage(Model model){
        return "chef-form";
    }



}
