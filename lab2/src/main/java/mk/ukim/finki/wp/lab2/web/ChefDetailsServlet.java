package mk.ukim.finki.wp.lab2.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab2.model.Chef;
import mk.ukim.finki.wp.lab2.model.Dish;
import mk.ukim.finki.wp.lab2.service.ChefService;
import mk.ukim.finki.wp.lab2.service.DishService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;


@WebServlet(name = "chefDetails", urlPatterns = "/chefDetails")
public class ChefDetailsServlet extends HttpServlet {

    public final SpringTemplateEngine templateEngine;
    public final ChefService chefService;
    public final DishService dishService;

    public ChefDetailsServlet(SpringTemplateEngine templateEngine, ChefService chefService, DishService dishService) {
        this.templateEngine = templateEngine;
        this.chefService = chefService;
        this.dishService = dishService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange iWebExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(iWebExchange);

        String chefId = req.getParameter("chefId");
        String dishId = req.getParameter("dishId");

        Chef chef = chefService.findById(Long.parseLong(chefId));

        chefService.addDishToChef(Long.parseLong(chefId), dishId);
        context.setVariable("ime", chef.firstName);
        context.setVariable("bio", chef.bio);
        context.setVariable("dishes", chef.dishes);

        templateEngine.process("chefDetails", context, resp.getWriter());

    }
}
